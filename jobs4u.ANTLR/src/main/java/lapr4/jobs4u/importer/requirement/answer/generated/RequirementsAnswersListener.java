package lapr4.jobs4u.importer.requirement.answer.generated;
// Generated from RequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsAnswersParser}.
 */
public interface RequirementsAnswersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RequirementsAnswersParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RequirementsAnswersParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(RequirementsAnswersParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(RequirementsAnswersParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#email}.
	 * @param ctx the parse tree
	 */
	void enterEmail(RequirementsAnswersParser.EmailContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#email}.
	 * @param ctx the parse tree
	 */
	void exitEmail(RequirementsAnswersParser.EmailContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(RequirementsAnswersParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(RequirementsAnswersParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(RequirementsAnswersParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(RequirementsAnswersParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsAnswersParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(RequirementsAnswersParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsAnswersParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(RequirementsAnswersParser.ContentContext ctx);
}