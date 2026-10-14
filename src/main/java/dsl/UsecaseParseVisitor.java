package dsl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import antlr.usecaseBaseVisitor;
import antlr.usecaseParser;
import antlr.usecaseParser.Usecase_defContext;
import antlr.usecaseParser.Usecase_specContext;
import metamodel.Condition;
import metamodel.Slice;
import metamodel.Usecase;
import metamodel.UsecaseSpecification;

public class UsecaseParseVisitor extends usecaseBaseVisitor<UsecaseSpecification> {

    private final List<Usecase> usecaseDefinitions = new ArrayList<>();

    @Override
    public UsecaseSpecification visitUsecase_spec(Usecase_specContext ctx) {
        try {
            for (Usecase_defContext usecaseDefCtx : ctx.usecase_def()) {
            usecaseDefinitions.add(visitUsecase(usecaseDefCtx));
        }
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate/invalid use case!");
            return null;
        } catch (ParseException e) {
            System.out.println("Use case parsing failed");
            return null;
        }
        
        return new UsecaseSpecification(usecaseDefinitions);
    }

    public Usecase visitUsecase(Usecase_defContext uc_ctx) throws ParseException {
        int id = Integer.parseInt(uc_ctx.usecase().INT().getText());
        String name = uc_ctx.usecase().STRING().getText().replace("\"", "");

        // Create usecase instance and go through/handle each usecase field

        Usecase result = new Usecase(id, name);
        result.setDescription(uc_ctx.description().STRING().getText().replace("\"", ""));

        System.out.println("Usecase UC" + result.getId() + " " + result.getName() + ", " + result.getDescription());

        for (Condition cond : visitPreconditions(uc_ctx.precond())) {
            result.addPrecondition(cond);
        }

        for (usecaseParser.FlowContext fl_ctx : uc_ctx.flow()) {
            try {
                result.addFlow(visitFlows(fl_ctx));
            } catch (ParseException e) {
                System.err.println("Parse exception at flow " + fl_ctx.STRING().getText() + ": " + e.getMessage() + " "
                        + e.getErrorOffset());
            }
        }

        for (Condition cond : visitPostconditions(uc_ctx.postcond())) {
            result.addPostcondition(cond);
        }

        // Append each field to the usecase

        System.out.println("Actors: " + result.getActors());
        return result;
    }

    // not great duplication here. fix later
    public List<Condition> visitPreconditions(usecaseParser.PrecondContext pc_ctx) throws ParseException {

        List<Condition> conditions = new ArrayList<>();

        for (usecaseParser.CondContext ctx : pc_ctx.cond()) {

            String entity = ctx.entity().STRING().getText().replace("\"", "");
            String condType = "";

            Condition cond = new Condition(entity);

            //
            if (ctx.property() != null) { // dealing with a "property" condition
                String propName = ctx.property().STRING().getText().replace("\"", "");
                String propValue = ctx.STRING().getText().replace("\"", "");
                cond.setPropName(propName);
                cond.setValue(propValue);
            } else // dealing with a "in state" condition
                cond.setValue(ctx.state().STRING().getText().replace("\"", ""));

            if (ctx.ISIN() != null) {
                condType = "STATE";
            } else if (ctx.NOTIN() != null) {
                condType = "NOTSTATE";
            } else if (ctx.EQUALS() != null) {
                condType = "EQUALS";
            } else if (ctx.GT() != null) {
                condType = "GREATERTHAN";
            } else if (ctx.LT() != null) {
                condType = "LESSTHAN";
            } else if (ctx.CONTAINS() != null) {
                condType = "CONTAINS";
            }

            cond.setCondType(condType);

            conditions.add(cond);
            System.out.println("PRECOND " + cond.getEntity() + " " + cond.getConditionType() + " " + cond.getValue());
        }

        return conditions;
    }

    public List<Condition> visitPostconditions(usecaseParser.PostcondContext pc_ctx) throws ParseException {

        List<Condition> conditions = new ArrayList<>();

        for (usecaseParser.CondContext ctx : pc_ctx.cond()) {

            String entity = ctx.entity().STRING().getText().replace("\"", "");
            String condType = "";

            Condition cond = new Condition(entity);

            //
            if (ctx.property() != null) { // dealing with a "property" condition
                String propName = ctx.property().STRING().getText().replace("\"", "");
                String propValue = ctx.STRING().getText().replace("\"", "");
                cond.setPropName(propName);
                cond.setValue(propValue);
            } else // dealing with a "in state" condition
                cond.setValue(ctx.state().STRING().getText().replace("\"", ""));

            if (ctx.ISIN() != null) {
                condType = "STATE";
            } else if (ctx.NOTIN() != null) {
                condType = "NOTSTATE";
            } else if (ctx.EQUALS() != null) {
                condType = "EQUALS";
            } else if (ctx.GT() != null) {
                condType = "GREATERTHAN";
            } else if (ctx.LT() != null) {
                condType = "LESSTHAN";
            } else if (ctx.CONTAINS() != null) {
                condType = "CONTAINS";
            }

            cond.setCondType(condType);

            conditions.add(cond);
            System.out.println("POSTCOND " + cond.getEntity() + " " + cond.getConditionType() + " " + cond.getValue());
        }

        return conditions;
    }

    public Slice visitFlows(usecaseParser.FlowContext fl_ctx) throws ParseException {
        Slice flow = new Slice(fl_ctx.STRING().getText().replace("\"", ""));

        for (int i = 1; i <= fl_ctx.step().size(); i++) { // Parse and add steps
            usecaseParser.StepContext step = fl_ctx.step(i - 1);

            int stepIndex = Integer.parseInt(step.INT().getText());

            if (i != stepIndex) {
                throw new ParseException("Duplicate/out of order step!", i);
            }

            String type, entity, value, payloadKey, payloadValue, conditionType; // all possible fields
            type = entity = value = payloadKey = payloadValue = conditionType = null;

            if (step.USERACT() != null) { // User event
                type = "USEREVENT";
                value = step.STRING(0).getText().replace("\"", "");

                if (step.property() != null) { // Contains payload
                    payloadKey = step.property().STRING().getText().replace("\"", "");
                    payloadValue = step.STRING(1).getText().replace("\"", "");
                }

            } else if (step.FOR() != null) { // Property for entity
                type = "PROPERTY";
                entity = step.entity().STRING().getText().replace("\"", "");
                value = payloadKey = step.property().STRING().getText().replace("\"", "");
                payloadValue = step.STRING(0).getText().replace("\"", "");
                if (step.EQUALS() != null) {
                    conditionType = "EQUALS";
                } else if (step.LT() != null) {
                    conditionType = "LESSTHAN";
                } else if (step.GT() != null) {
                    conditionType = "GREATERTHAN";
                } else if (step.CONTAINS() != null) {
                    conditionType = "CONTAINS";
                }

            } else if (step.TRANS() != null) { // State transition for entity
                type = "STATE";
                entity = step.entity().STRING().getText().replace("\"", "");
                value = step.state().STRING().getText().replace("\"", "");
            }
            
            flow.addStep(stepIndex, type, entity, value, payloadKey, payloadValue, conditionType);
        }

        return flow;
    }

}
