package lapr4.jobs4u.importer.csv.generated.interview;
// Generated from InterviewCsv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewCsvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewCsvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(InterviewCsvParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(InterviewCsvParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(InterviewCsvParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewCsvParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#questionCotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionCotation(InterviewCsvParser.QuestionCotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(InterviewCsvParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#answerCotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerCotation(InterviewCsvParser.AnswerCotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewCsvParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(InterviewCsvParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewCsvParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(InterviewCsvParser.CotationTypeContext ctx);
}