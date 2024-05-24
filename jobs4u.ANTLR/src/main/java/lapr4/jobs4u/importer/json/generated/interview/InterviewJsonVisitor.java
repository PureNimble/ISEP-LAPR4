package lapr4.jobs4u.importer.json.generated.interview;
// Generated from InterviewJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewJsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewJsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(InterviewJsonParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(InterviewJsonParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(InterviewJsonParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewJsonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(InterviewJsonParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#answerCotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerCotation(InterviewJsonParser.AnswerCotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewJsonParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(InterviewJsonParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewJsonParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(InterviewJsonParser.CotationTypeContext ctx);
}