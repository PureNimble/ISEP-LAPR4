package lapr4.jobs4u.importer.xml.generated.interview;
// Generated from InterviewXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewXmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewXmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(InterviewXmlParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(InterviewXmlParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewXmlParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(InterviewXmlParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(InterviewXmlParser.CotationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewXmlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(InterviewXmlParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#questionCotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionCotation(InterviewXmlParser.QuestionCotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#answerCotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerCotation(InterviewXmlParser.AnswerCotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswersList(InterviewXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswers(InterviewXmlParser.PossibleAnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewXmlParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(InterviewXmlParser.AnswerContext ctx);
}