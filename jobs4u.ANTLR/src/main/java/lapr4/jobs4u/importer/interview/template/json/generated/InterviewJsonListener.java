package lapr4.jobs4u.importer.interview.template.json.generated;
// Generated from InterviewJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewJsonParser}.
 */
public interface InterviewJsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(InterviewJsonParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(InterviewJsonParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(InterviewJsonParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(InterviewJsonParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(InterviewJsonParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(InterviewJsonParser.QuestionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(InterviewJsonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(InterviewJsonParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#questionCotation}.
	 * @param ctx the parse tree
	 */
	void enterQuestionCotation(InterviewJsonParser.QuestionCotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#questionCotation}.
	 * @param ctx the parse tree
	 */
	void exitQuestionCotation(InterviewJsonParser.QuestionCotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(InterviewJsonParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(InterviewJsonParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#answerCotation}.
	 * @param ctx the parse tree
	 */
	void enterAnswerCotation(InterviewJsonParser.AnswerCotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#answerCotation}.
	 * @param ctx the parse tree
	 */
	void exitAnswerCotation(InterviewJsonParser.AnswerCotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(InterviewJsonParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(InterviewJsonParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(InterviewJsonParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(InterviewJsonParser.CotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewJsonParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void enterCotationType(InterviewJsonParser.CotationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewJsonParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void exitCotationType(InterviewJsonParser.CotationTypeContext ctx);
}