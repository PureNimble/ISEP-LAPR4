package lapr4.jobs4u.exporter.requirement.answer.generated;
// Generated from EvaluateRequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EvaluateRequirementsAnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EvaluateRequirementsAnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EvaluateRequirementsAnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(EvaluateRequirementsAnswersParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(EvaluateRequirementsAnswersParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(EvaluateRequirementsAnswersParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(EvaluateRequirementsAnswersParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(EvaluateRequirementsAnswersParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#justification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustification(EvaluateRequirementsAnswersParser.JustificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateRequirementsAnswersParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(EvaluateRequirementsAnswersParser.ContentContext ctx);
}