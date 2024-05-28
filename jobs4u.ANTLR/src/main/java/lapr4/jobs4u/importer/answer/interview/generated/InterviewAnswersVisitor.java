package lapr4.jobs4u.importer.answer.interview.generated;
// Generated from InterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewAnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewAnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewAnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(InterviewAnswersParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(InterviewAnswersParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(InterviewAnswersParser.CotationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(InterviewAnswersParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(InterviewAnswersParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(InterviewAnswersParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(InterviewAnswersParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(InterviewAnswersParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewAnswersParser.TypeContext ctx);
}