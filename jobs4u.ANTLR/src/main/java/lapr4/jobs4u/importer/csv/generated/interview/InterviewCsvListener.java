package lapr4.jobs4u.importer.csv.generated.interview;
// Generated from InterviewCsv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewCsvParser}.
 */
public interface InterviewCsvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(InterviewCsvParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(InterviewCsvParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(InterviewCsvParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(InterviewCsvParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(InterviewCsvParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(InterviewCsvParser.QuestionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(InterviewCsvParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(InterviewCsvParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(InterviewCsvParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(InterviewCsvParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#answerCotation}.
	 * @param ctx the parse tree
	 */
	void enterAnswerCotation(InterviewCsvParser.AnswerCotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#answerCotation}.
	 * @param ctx the parse tree
	 */
	void exitAnswerCotation(InterviewCsvParser.AnswerCotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(InterviewCsvParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(InterviewCsvParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(InterviewCsvParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(InterviewCsvParser.CotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewCsvParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void enterCotationType(InterviewCsvParser.CotationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewCsvParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void exitCotationType(InterviewCsvParser.CotationTypeContext ctx);
}