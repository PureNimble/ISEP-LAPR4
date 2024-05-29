package lapr4.jobs4u.importer.requirement.template.csv.generated;
// Generated from RequirementsCsv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsCsvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsCsvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(RequirementsCsvParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(RequirementsCsvParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(RequirementsCsvParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(RequirementsCsvParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#minimumRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinimumRequirement(RequirementsCsvParser.MinimumRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsCsvParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(RequirementsCsvParser.QuestionContext ctx);
}