/**
 * Largely adapted from the karpfenproject/connectors main method, in order to set up the KarpfenConnector class.
 * 
 */

import java.net.http.WebSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import dsl.UsecaseFileParser;
import metamodel.UsecaseSpecification;

/** Minimal Karpfen client */
public class Main {

    // ── Configuration ────────────────────────────────────────────────────────
    static final String HOST       = "127.0.0.1";
    static final int    PORT       = 8080;
    static final String CLIENT_ID  = "java-client";
    static final String LIGHT_ID   = "light";              // lightbulb instance ID in world.kmodel
    static final int    TICK_MS    = 1000;                 // engine tick delay
    static final int    EVENT_TTL  = 5000;                 // unconsumed events expire after 5 s
    static final String MODELS_DIR = "../usedsl/src/main/example_models/"; // relative to the java_starter/ working directory
    static final String UCASE_DEF  = "lamp_example.usecase"; // if you want to use a different use case

    public static void main(String[] args) throws Exception {

        // ── Load usecase definition file from disk ───────────────────────────────────
        String usecaseString = Files.readString(Path.of(MODELS_DIR + UCASE_DEF));

        UsecaseFileParser parser = new UsecaseFileParser();
        UsecaseSpecification usecases = parser.parseString(usecaseString);
        
        UsecaseRunner runner = new UsecaseRunner();

        Semaphore lock = new Semaphore(1);

        // ── Karpfen connection section starts here ───────────────────────────────────

        var connector = new KarpfenConnector(HOST, PORT);

        // ── Load model artefacts from disk ───────────────────────────────────
        
        var metamodel    = Files.readString(Path.of(MODELS_DIR + "domain.kmeta"));
        var model        = Files.readString(Path.of(MODELS_DIR + "world.kmodel"));
        var statemachine = Files.readString(Path.of(MODELS_DIR + "lightbulb.kstates"));
        var eventDefs    = Files.readString(Path.of(MODELS_DIR + "EVENTS.kmeta"));

        /* 
        String robot_dir = "../usedsl/src/main/example_models/single_robot_example/";
        metamodel    = Files.readString(Path.of(robot_dir + "cleaning_robot.kmeta"));
        model        = Files.readString(Path.of(robot_dir + "cleaning_robot.kmodel"));
        statemachine = Files.readString(Path.of(robot_dir + "cleaning_robot.kstates"));
        eventDefs    = Files.readString(Path.of(robot_dir + "EVENTS.kmeta"));
        */

        System.out.println("Connecting to Karpfen runtime at " + HOST + ":" + PORT + " …");
        if (!connector.health()) {
            System.err.println("Karpfen runtime not reachable at " + HOST + ":" + PORT + " — is the server running?");
            System.exit(1);
        }

        // ── 1. Create a new execution environment ────────────────────────────
        var envKey = connector.createEnvironment();
        System.out.println("Environment: " + envKey);

        // ── 2. Register the model artefacts (metamodel first) ────────────────
        connector.setMetamodel(envKey, metamodel);
        connector.setModel(envKey, model);
        connector.setEventDefinitions(envKey, eventDefs);
        connector.setStateMachine(envKey, LIGHT_ID, statemachine);
        //connector.setStateMachine(envKey, "turtle", statemachine); // TURTLE 
        System.out.println("Models registered.");

        // ── 3. Configure engine timing ───────────────────────────────────────
        connector.setTickDelay(envKey, TICK_MS);
        connector.setEventTtl(envKey, EVENT_TTL);

        // ── 4. Register client and subscribe to object-change notifications ──
        var accessKey = connector.registerClientForWebSocket(CLIENT_ID, envKey);

        // Request notifications whenever the "light" object's properties change
        // For this sample application, just get all entities

        for (metamodel.Usecase ucase : usecases.getAllUsecases()) {
            for (String entity : ucase.getActors()) {
                connector.registerObjectObserver(envKey, CLIENT_ID, entity);
            }
        } 

        connector.registerObservatoryClient(CLIENT_ID, envKey, "*"); //observe all state changes

        // ── 5. Activate and start the engine ─────────────────────────────────
        connector.runEnvironment(envKey);
        connector.startEnvironment(envKey);
        System.out.println("Environment started (tick every " + TICK_MS + " ms).");

        // ── 6. Connect WebSocket — background thread prints object changes ────
        // connectWebSocket authenticates the session and delivers messages
        // to the callback on an HttpClient background thread.
        // SM - expanded the Consumer to relay events to the runner class.
        WebSocket ws = connector.connectWebSocket(CLIENT_ID, envKey, accessKey,
                message -> {
                System.out.println("[OBSERVATION] " + message);
                runner.loadMessage(message);
                lock.release();
                })
                ;
        System.out.println("WebSocket connected.\n");

        // Stop the environment on exit (Ctrl+C or end of input)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                connector.stopEnvironment(envKey);
                System.out.println("Environment stopped.");
            } catch (Exception e) {
                System.err.println("Could not stop environment: " + e.getMessage());
            }
        }));

        // ── Finish setting up usecase runner

        runner.setTickDelay(TICK_MS);
        runner.setEventTtl(EVENT_TTL);
        runner.setWebsocket(ws);
        runner.setConnector(connector);
        runner.setEnvKey(envKey);
        runner.setSpec(usecases);
        runner.setLock(lock);

        // ── 7. Keyboard loop
        System.out.println("Input use case ID");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String id = scanner.nextLine().strip(); // block until Enter is pressed
            try {
                Double.parseDouble(id);
            } catch (NumberFormatException e) {
                System.out.println("Not a number: '" + id + "'");
                continue;
            }

            System.out.println("Input flow name (case sensitive)");
            var flow = scanner.nextLine().strip();

            runner.selectUsecase(Integer.parseInt(id));
            runner.selectFlow(flow);

            Thread runnerThread = new Thread(runner);
            runnerThread.start();
            System.out.println("thread started");
            runnerThread.join();
            System.out.println("Usecase runner thread joined");
        }
    }
}
