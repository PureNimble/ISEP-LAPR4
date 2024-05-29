package lapr4.jobs4u.exporter.interview.answer.generated;
// Generated from EvaluateInterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EvaluateInterviewAnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EvaluateInterviewAnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EvaluateInterviewAnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(EvaluateInterviewAnswersParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(EvaluateInterviewAnswersParser.CotationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(EvaluateInterviewAnswersParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(EvaluateInterviewAnswersParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(EvaluateInterviewAnswersParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(EvaluateInterviewAnswersParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(EvaluateInterviewAnswersParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(EvaluateInterviewAnswersParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link EvaluateInterviewAnswersParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EvaluateInterviewAnswersParser.TypeContext ctx);
}