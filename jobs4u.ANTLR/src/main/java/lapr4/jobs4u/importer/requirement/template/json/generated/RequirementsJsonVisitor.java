package lapr4.jobs4u.importer.requirement.template.json.generated;
// Generated from RequirementsJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsJsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsJsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(RequirementsJsonParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(RequirementsJsonParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(RequirementsJsonParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(RequirementsJsonParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#minimumRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinimumRequirement(RequirementsJsonParser.MinimumRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsJsonParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(RequirementsJsonParser.QuestionContext ctx);
}