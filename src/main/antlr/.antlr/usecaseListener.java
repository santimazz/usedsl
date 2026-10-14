// Generated from c:/Users/santi/OneDrive/Documentos/swt-ba/usedsl/src/main/antlr/usecase.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link usecaseParser}.
 */
public interface usecaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link usecaseParser#usecase_spec}.
	 * @param ctx the parse tree
	 */
	void enterUsecase_spec(usecaseParser.Usecase_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#usecase_spec}.
	 * @param ctx the parse tree
	 */
	void exitUsecase_spec(usecaseParser.Usecase_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#usecase_def}.
	 * @param ctx the parse tree
	 */
	void enterUsecase_def(usecaseParser.Usecase_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#usecase_def}.
	 * @param ctx the parse tree
	 */
	void exitUsecase_def(usecaseParser.Usecase_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#usecase}.
	 * @param ctx the parse tree
	 */
	void enterUsecase(usecaseParser.UsecaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#usecase}.
	 * @param ctx the parse tree
	 */
	void exitUsecase(usecaseParser.UsecaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(usecaseParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(usecaseParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(usecaseParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(usecaseParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#actors}.
	 * @param ctx the parse tree
	 */
	void enterActors(usecaseParser.ActorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#actors}.
	 * @param ctx the parse tree
	 */
	void exitActors(usecaseParser.ActorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#precond}.
	 * @param ctx the parse tree
	 */
	void enterPrecond(usecaseParser.PrecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#precond}.
	 * @param ctx the parse tree
	 */
	void exitPrecond(usecaseParser.PrecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterFlow(usecaseParser.FlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitFlow(usecaseParser.FlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(usecaseParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(usecaseParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#postcond}.
	 * @param ctx the parse tree
	 */
	void enterPostcond(usecaseParser.PostcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#postcond}.
	 * @param ctx the parse tree
	 */
	void exitPostcond(usecaseParser.PostcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(usecaseParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(usecaseParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(usecaseParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(usecaseParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(usecaseParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(usecaseParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link usecaseParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(usecaseParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link usecaseParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(usecaseParser.StateContext ctx);
}