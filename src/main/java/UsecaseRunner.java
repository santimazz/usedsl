
import java.net.http.WebSocket;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Semaphore;

import org.json.JSONArray;
import org.json.JSONObject;

import metamodel.Condition;
import metamodel.Slice;
import metamodel.Step;
import metamodel.Usecase;
import metamodel.UsecaseSpecification;

public class UsecaseRunner implements Runnable {
    private int tick_ms;
    private int event_ttl;

    private Stack<JSONObject> msgStack = new Stack<>();
    private JSONObject msg = null;

    private KarpfenConnector connector;
    private UsecaseSpecification spec;
    private WebSocket ws;
    private String envKey;
    private Semaphore lock;
    private int usecaseIndex;
    private String flowId;

    public void run() {
        executeUsecase(usecaseIndex, flowId);
    }

    public void selectUsecase(int index) {
        this.usecaseIndex = index;
    }

    public void selectFlow(String flowId) {
        this.flowId = flowId;
    }

    public void setLock(Semaphore lock) {
        this.lock = lock;
    }

    public void setConnector(KarpfenConnector connector) {
        this.connector = connector;
    }

    public void setSpec(UsecaseSpecification spec) {
        this.spec = spec;
    }

    public void setWebsocket(WebSocket ws) {
        this.ws = ws;
    }

    public void setEnvKey(String envKey) {
        this.envKey = envKey;
    }

    /**
     * Sets the runner's internal tick rate. Should match the running Karpfen
     * instance.
     * 
     * @param tickrate The engine tickrate in milliseconds.
     */
    public void setTickDelay(int tickrate) {
        this.tick_ms = tickrate;
    }

    /**
     * Sets the runner's event time-to-live to handle timeouts. Should match the
     * running Karpfen instance.
     * 
     * @param tickrate The engine time-to-live in milliseconds.
     */
    public void setEventTtl(int ttl) {
        this.event_ttl = ttl;
    }

    /**
     * Updates the current message to be read for checks. Should be called by a
     * Consumable in the connector.
     * 
     * @param message The raw message from the Karpfen environment, as a string
     */
    public void loadMessage(String message) {
        msgStack.add(new JSONObject(message));
    }

    /**
     * Verifies a given use case against a running Karpfen instance.
     * 
     * During the precondition phase, each condition is tested in their order within
     * the definition.
     * 
     * Preconditions of type "Entity in state X" are enforced by setting the
     * corresponding active state.
     * 
     * Preconditions of type "Property EQ/LT/GT/CNT" are enforced by listing the
     * environments, then checking if the property is present in the model elements
     * and matches the comparison. <- Not implemented so far, since properties are
     * only exposed when changes occur
     * 
     * ─────────────────────────────────
     * 
     * For each flow, steps are evaluated in order, with a different process per
     * type:
     * 
     * Steps of type "User performs action" send a single event (with optional
     * payload).
     * 
     * Steps of type "Entity transitions to state X" listen for "stateChange"
     * messages from the server.
     * 
     * Steps of type "Property EQ/LT/GT/CNT" listen for "objectChanged" messages
     * from the server, and compare values accordingly.
     * 
     * ─────────────────────────────────
     * 
     * During the postcondition phase, properties are verified in the same way as
     * preconditions, but states are only observed and not set.
     * 
     * @param index The number for the use case to execute, according to the
     *              specification
     * @return Whether the use case was fulfilled or not.
     */
    public Boolean executeUsecase(Integer index, String flowid) {
        Usecase usecase = spec.getUsecase(index);
        System.out.println("Executing usecase " + usecase.getName());

        // Precondition checking/enforcing

        for (Condition precond : usecase.getPreconditions()) {
            System.out.println("Precond check for entity " + precond.getEntity());
            if (!precondition(precond)) {
                System.out.println("Preconditions unfulfilled!");
                return false;
            }
        }

        // Flow running
        if (usecase.getFlow(flowid) == null) {
            System.out.println("Usecase flow " + flowId + " does not exist!");
        }
        if (!runFlow(usecase.getFlow(flowid))) {
            System.out.println("Usecase flow " + flowid + " unfulfilled!");
            return false;
        }

        // Postcondition checking - cannot be implemented still

        for (Condition postcond : usecase.getPreconditions()) {
            System.out.println("Postcond check for entity " + postcond.getEntity());
            if (!postcondition(postcond)) {
                System.out.println("Preconditions unfulfilled!");
                return false;
            }
        }

        return (true);
    }

    public Boolean precondition(Condition cond) {
        String modelElement = cond.getEntity();

        switch (cond.getConditionType()) {
        case STATE:
            System.out.println("forcing state " + cond.getValue());
            try {
                connector.setActiveState(envKey, modelElement, cond.getValue());
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        default: {
            return true; // STUB, PROPERTY CHECKS CANNOT BE IMPLEMENTED YET!
        }

        }

    }

    public Boolean runFlow(Slice flow) {
        Boolean result = true;

        try {
            for (Step step : flow.getSteps()) {
                runStep(step);

            }

            System.out.println("All steps done!");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return result;
    }

    public Boolean runStep(Step step) throws InterruptedException {
        lock.acquire();

        switch (step.getType()) {

        case USEREVENT -> {
            String userPayload = null;
            System.out.println("Sending user event " + step.getValue());
            if (step.getPayload() != null) {
                userPayload = "{";

                for (String key : step.getPayload().keySet()) {
                    userPayload = userPayload + key + ": " + step.getPayload().get(key);
                }

                userPayload = userPayload + "}";
            }
            msg = null;
            KarpfenConnector.sendEvent(ws, "public", step.getValue(), userPayload);
            // no need to check for return message here
            return true;
        }
        case STATE -> {
            System.out.println("Entity " + step.getEntity() + ": changing state to " + step.getValue() + "?");
            // loop to check next couple of messages for relevant events

            for (int i = 0; i <= event_ttl / tick_ms + 1; i++) { // Times out after the event TTL expires
                System.out.println("attempt no." + (i + 1));
                typeGuard("stateChange");
                JSONObject payload = new JSONObject(    msg.get("payload").toString()); // this feels gross
                if (payload.get("modelElementId").equals(step.getEntity())) {
                    JSONArray jsonArrayStack = (JSONArray) payload.get("stack");
                    List stack = jsonArrayStack.toList();
                    if (stack.contains(step.getValue())) {
                        System.out.println("STATE success");
                        return true;
                    }
                    msg = null;
                }
            }
        }
        case PROPERTY -> {

            System.out.println("Entity " + step.getEntity() + ": has property " + step.getConditionType()
                    + step.getPayload() + "?");

            for (int i = 0; i <= event_ttl / tick_ms + 1; i++) { // Times out after the event TTL expires, roughly
                System.out.println("attempt no." + (i + 1));

                typeGuard("objectChanged"); // cycle through stack until we get an objectChanged notif

                JSONObject payload = new JSONObject(msg.get("payload").toString());
                JSONObject value = new JSONObject(payload.get("value").toString()); // double unpack...

                if (value.get("__id__").equals(step.getEntity())) { // entity has actually changed

                    if (payload.get("objectId").equals(step.getEntity())) { // double check

                        if (value.has(step.getValue())) { // property is also correct

                            String modelValue = value.get(step.getValue()).toString();
                            String expValue = step.getPayload().get(step.getValue());

                            switch (step.getConditionType()) {

                            case EQUALS:
                                System.out.println(modelValue + " ? " + expValue);
                                if (modelValue.equals(expValue)) {
                                    System.out.println("EQUALS Success");
                                    return true;
                                }
                                System.out.println("Condition not fulfilled");
                                break;
                            case LESSTHAN:
                                int intExpValue = Integer.parseInt(expValue);

                                int intModelValue = Integer.parseInt(modelValue);

                                System.out.println(intModelValue + " <? " + intExpValue);
                                if (intModelValue <= intExpValue) {
                                    System.out.println("LESSTHAN Success");
                                    return true;
                                }
                                System.out.println("Condition not fulfilled");
                                break;
                            case GREATERTHAN:
                                intExpValue = Integer.parseInt(expValue);

                                intModelValue = Integer.parseInt(modelValue);

                                System.out.println(modelValue + " >? " + expValue);
                                if (intModelValue >= intExpValue) {
                                    System.out.println("GREATERTHAN Success");
                                    return true;
                                }
                                System.out.println("Condition not fulfilled");
                                break;
                            case CONTAINS:
                                System.out.println(modelValue + " contains? " + expValue);
                                if (modelValue.contains(expValue)) {
                                    System.out.println("CONTAINS Success");
                                    return true;
                                }
                                System.out.println("Condition not fulfilled");
                                break;
                            default:
                                System.out.println("Undefined condition!");
                                return false;
                            }
                            msg = null;
                        }
                    }
                }
                lock.acquire(); // if we got here, it means no updates. so we lock until next one
            }
            return false;
        }
        }
        return false;
    }

    public Boolean postcondition(Condition cond) {
        //

        return true;
    }

    /**
     * This helper method makes sure we don't miss messages or read the wrong type,
     * which can cause the step evaluation to crash. If the current "msg" JSONObject
     * has messageType equaling the string it proceeds as normal, otherwise it
     * discards it and picks the next one from the stack. If there are no more
     * messages in the stack, the runner is locked until a new message comes in.
     * 
     * @param checkFor
     */
    public void typeGuard(String checkFor) throws InterruptedException {
        if (msg == null && !msgStack.isEmpty()) {
            System.out.println("Taking new message from stack");
            msg = msgStack.pop();
        }

        if (msg.get("messageType").equals(checkFor)) {
            System.out.println(msg.get("messageType"));
            System.out.println("Correct message type, " + checkFor);
            return;
        } else
            while (!msg.get("messageType").equals(checkFor)) {
                System.out.println(msg.get("messageType"));
                System.out.println("Wrong message type, removing");
                if (msgStack.isEmpty()) {
                    System.out.println("Waiting for new messages");
                    lock.acquire();
                }
                msg = msgStack.pop();

            }
        System.out.println("Message get with " + msg.get("messageType"));

    }
}
