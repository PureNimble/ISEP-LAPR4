package lapr4.jobs4u.exporter.interview.template.generated;
// Generated from Interview.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewParser}.
 */
public interface InterviewListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InterviewParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InterviewParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(InterviewParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(InterviewParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(InterviewParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(InterviewParser.CotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void enterCotationType(InterviewParser.CotationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void exitCotationType(InterviewParser.CotationTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(InterviewParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(InterviewParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(InterviewParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(InterviewParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(InterviewParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(InterviewParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(InterviewParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(InterviewParser.TypeContext ctx);
}