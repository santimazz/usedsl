package metamodel;

import java.util.HashMap;
import java.util.Map;

import metamodel.Condition.ConditionType;

public class Step {

        private int index;

        public enum StepType {
            USEREVENT,
            STATE,
            PROPERTY,
        }
        private StepType stepType;
        public Condition.ConditionType conditionType;

        private String entity;
        private String value; // Either the property to listen for, the name, or the event title (not the payload!)
        private Map<String, String> payload; // Key-value pairs

        public Step(int index) {
            this.index = index;
            payload = new HashMap<>();
        }


        public void setType(String type) {
            switch (type) {
                case "USEREVENT":
                    this.stepType = StepType.USEREVENT;
                    break;
                case "STATE":
                    this.stepType = StepType.STATE;
                    break;
                case "PROPERTY":
                    this.stepType = StepType.PROPERTY;
                    break;
                default:
                    throw new AssertionError();
            }
        }

    public void setCondType(String conditionType) {

        switch (conditionType){
            case "EQUALS":
                this.conditionType = ConditionType.EQUALS;
                break;
            case "LESSTHAN":
                this.conditionType = ConditionType.LESSTHAN;
                break;
            case "GREATERTHAN":
                this.conditionType = ConditionType.GREATERTHAN;
                break;
            case "CONTAINS":
                this.conditionType = ConditionType.CONTAINS;
                break;
        }
    }


        public void setEntity(String entity) {
            this.entity = entity;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setPayload(String key, String value) {
            this.payload.put(key, value);
            System.out.println(key + value);
        }

        public StepType getType() {
            return stepType;
        }

        public ConditionType getConditionType() {
        return conditionType;
        }

        public String getEntity() {
            return entity;
        }
        public String getValue() {
            return value;
        }
        public Map<String, String> getPayload() {
            return payload;
        }
}