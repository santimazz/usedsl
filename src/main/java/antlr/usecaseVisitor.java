package antlr;
// Generated from usecase.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link usecaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface usecaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link usecaseParser#usecase_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecase_spec(usecaseParser.Usecase_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#usecase_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecase_def(usecaseParser.Usecase_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#usecase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecase(usecaseParser.UsecaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(usecaseParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(usecaseParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#actors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActors(usecaseParser.ActorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#precond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond(usecaseParser.PrecondContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow(usecaseParser.FlowContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(usecaseParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#postcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcond(usecaseParser.PostcondContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(usecaseParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(usecaseParser.EntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(usecaseParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link usecaseParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(usecaseParser.StateContext ctx);
}