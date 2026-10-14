package metamodel;

public class Condition {

    // The entity to be checked within the model
    private String entity;

    public enum ConditionType {
        STATE,
        NOTSTATE,
        EQUALS,
        LESSTHAN,
        GREATERTHAN,
        CONTAINS
    }
    public enum ValueType {
        STRING,
        NUMBER,
        BOOLEAN,
        OTHER
    }

    private ConditionType conditionType; 
    private ValueType valueType;

    private String propertyName;

    private String stringValue;

    public Condition(String entity) {
        this.entity = entity;
    }

    public void setCondType(String conditionType) {

        switch (conditionType){
            case "STATE":
                this.conditionType = ConditionType.STATE;
                break;
            case "NOTSTATE":
                this.conditionType = ConditionType.NOTSTATE;
                break;
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

    public void setPropName(String propName) {
        this.propertyName = propName;
    }

    public void setValue(String value) {
        this.valueType = ValueType.STRING;
        this.stringValue = value;
    }
    public void setValue(Double value) {
        this.valueType = ValueType.NUMBER;
        this.stringValue = value.toString();
    }
    public void setValue(Boolean value) {
        this.valueType = ValueType.BOOLEAN;
        this.stringValue = value.toString();
    }

    public String getEntity() {
        return entity;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public String getValue() {
        if (conditionType == ConditionType.STATE || conditionType == ConditionType.NOTSTATE) {
            return stringValue;
        } else 
            return (propertyName + " = " + stringValue);
    }
}
