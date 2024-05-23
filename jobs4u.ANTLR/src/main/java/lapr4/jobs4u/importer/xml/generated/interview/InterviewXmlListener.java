package lapr4.jobs4u.importer.xml.generated;
// Generated from InterviewXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewXmlParser}.
 */
public interface InterviewXmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(InterviewXmlParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(InterviewXmlParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(InterviewXmlParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(InterviewXmlParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(InterviewXmlParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(InterviewXmlParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(InterviewXmlParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(InterviewXmlParser.CotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void enterCotationType(InterviewXmlParser.CotationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#cotationType}.
	 * @param ctx the parse tree
	 */
	void exitCotationType(InterviewXmlParser.CotationTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(InterviewXmlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(InterviewXmlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(InterviewXmlParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(InterviewXmlParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswersList(InterviewXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswersList(InterviewXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswers(InterviewXmlParser.PossibleAnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswers(InterviewXmlParser.PossibleAnswersContext ctx);
}