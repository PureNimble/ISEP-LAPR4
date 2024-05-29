package lapr4.jobs4u.importer.requirement.template.csv.generated;
// Generated from RequirementsCsv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsCsvParser}.
 */
public interface RequirementsCsvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(RequirementsCsvParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(RequirementsCsvParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(RequirementsCsvParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(RequirementsCsvParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(RequirementsCsvParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(RequirementsCsvParser.QuestionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(RequirementsCsvParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(RequirementsCsvParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void enterMinimumRequirement(RequirementsCsvParser.MinimumRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#minimumRequirement}.
	 * @param ctx the parse tree
	 */
	void exitMinimumRequirement(RequirementsCsvParser.MinimumRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsCsvParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(RequirementsCsvParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsCsvParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(RequirementsCsvParser.QuestionContext ctx);
}