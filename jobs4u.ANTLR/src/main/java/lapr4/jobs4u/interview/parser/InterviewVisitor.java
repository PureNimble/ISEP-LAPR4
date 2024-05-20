package lapr4.jobs4u.interview.parser;
// Generated from Interview.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(InterviewParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(InterviewParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(InterviewParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(InterviewParser.OptionContext ctx);
}