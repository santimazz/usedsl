package metamodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slice {

    private String title;
    private Set<String> entities;
    private List<Step> steps;

    public Slice(String title) {
        this.title = title;
        entities = new HashSet<>();
        steps = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getEntities() {
        return entities;
    }

    public List<Step> getSteps() {
        return steps;
    }

    /**
     * Constructor that instantiates a new Step with the proper fields set.
     * 
     * @param index the number of the step to add. no duplicates allowed within a Slice.
     * @param type One of the following: USEREVENT, STATE or PROPERTY.
     * @param entity The name of the entity in the model to watch property/state changes for.
     * @param value The name of the event to send (for USEREVENT), the state change to check for (for STATE), 
     *              or the property name to listen for (for PROPERTY)
     * @param payloadKey Only valid for USEREVENT types
     * @param payloadValue Only valid for USEREVENT types (key-value), or PROPERTY (value of the property to check)
     */
    public void addStep(int index, String type, String entity, String value, String payloadKey, String payloadValue, String conditionType) throws IllegalArgumentException {

        if (steps.size() != index - 1) throw new IllegalArgumentException("Duplicate use case step " + index +"!");

        Step step = new Step(index);
        step.setType(type);
        step.setValue(value);
        if (conditionType != null) {
            step.setCondType(conditionType);
        }

        switch (type) {
            
            case "USEREVENT": // User events have no real "entity"
                if (payloadKey != null && payloadValue != null) {
                    step.setPayload(payloadKey, payloadValue);
                }
                break;
            case "STATE":
                step.setEntity(entity);
                this.entities.add(entity);
                break;
            case "PROPERTY":
                step.setEntity(entity);
                this.entities.add(entity);
                step.setPayload(payloadKey, payloadValue);
                break;
            default:
                throw new AssertionError();
        }

        this.steps.add(step);
    }
}

