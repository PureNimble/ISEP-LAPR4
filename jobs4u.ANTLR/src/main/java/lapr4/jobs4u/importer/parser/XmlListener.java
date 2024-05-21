package lapr4.jobs4u.importer.parser;
// Generated from Xml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XmlParser}.
 */
public interface XmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(XmlParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(XmlParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(XmlParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(XmlParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(XmlParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(XmlParser.CotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(XmlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(XmlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(XmlParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(XmlParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswersList(XmlParser.PossibleAnswersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswersList(XmlParser.PossibleAnswersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswers(XmlParser.PossibleAnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswers(XmlParser.PossibleAnswersContext ctx);
}