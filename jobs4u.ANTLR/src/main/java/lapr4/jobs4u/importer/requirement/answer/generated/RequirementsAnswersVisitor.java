package lapr4.jobs4u.importer.requirement.answer.generated;
// Generated from RequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsAnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsAnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RequirementsAnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(RequirementsAnswersParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(RequirementsAnswersParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(RequirementsAnswersParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(RequirementsAnswersParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsAnswersParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(RequirementsAnswersParser.ContentContext ctx);
}