package lapr4.jobs4u.importer.json.generated.requirement;
// Generated from RequirementsJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsJsonParser}.
 */
public interface RequirementsJsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(RequirementsJsonParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(RequirementsJsonParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(RequirementsJsonParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(RequirementsJsonParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(RequirementsJsonParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(RequirementsJsonParser.QuestionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(RequirementsJsonParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(RequirementsJsonParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void enterMinimumRequirement(RequirementsJsonParser.MinimumRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void exitMinimumRequirement(RequirementsJsonParser.MinimumRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsJsonParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(RequirementsJsonParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsJsonParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(RequirementsJsonParser.QuestionContext ctx);
}