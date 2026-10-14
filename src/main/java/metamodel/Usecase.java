package metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Usecase {

    private int id;
    private String name, description;
    private Set<String> actors;
    private List<Condition> preconditions, postconditions;
    private Map<String, Slice> flows;

    public Usecase(int id, String name) {
        this.id = id;
        this.name = name;

        this.actors = new HashSet<>();
        this.preconditions = new ArrayList<>();
        this.postconditions = new ArrayList<>();
        this.flows = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPrecondition(Condition condition) {
        this.preconditions.add(condition);
        this.actors.add(condition.getEntity());
    }

    public void addPostcondition(Condition condition) {
        this.postconditions.add(condition);
        this.actors.add(condition.getEntity());
    }

    public void addFlow(Slice slice) throws IllegalArgumentException {
        if (!this.flows.containsKey(slice.getTitle())) {
            this.flows.put(slice.getTitle(), slice);
        } else throw new IllegalArgumentException("Duplicate flow!");
        
        for (String entity : slice.getEntities()) {
            this.actors.add(entity);
        }
    }

    public Set<String> getActors() {
        return actors;
    }

    public List<Condition> getPreconditions() {
        return preconditions;
    }

    public List<Condition> getPostconditions() {
        return postconditions;
    }

    public Slice getFlow(String flowId) throws IllegalArgumentException {
        if (flows.containsKey(flowId)) {
            return flows.get(flowId);
        } else throw new IllegalArgumentException("Duplicate flow ID: " + flows.get(flowId));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}