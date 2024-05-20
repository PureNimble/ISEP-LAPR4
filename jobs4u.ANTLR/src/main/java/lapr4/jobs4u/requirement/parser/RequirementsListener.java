package lapr4.jobs4u.requirement.parser;
// Generated from Requirements.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsParser}.
 */
public interface RequirementsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RequirementsParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RequirementsParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(RequirementsParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(RequirementsParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(RequirementsParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(RequirementsParser.ContentContext ctx);
}