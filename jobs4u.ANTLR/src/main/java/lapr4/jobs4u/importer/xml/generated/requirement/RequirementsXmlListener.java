package lapr4.jobs4u.importer.xml.generated.requirement;
// Generated from RequirementsXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementsXmlParser}.
 */
public interface RequirementsXmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(RequirementsXmlParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(RequirementsXmlParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(RequirementsXmlParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(RequirementsXmlParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(RequirementsXmlParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(RequirementsXmlParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(RequirementsXmlParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(RequirementsXmlParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswersList(RequirementsXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswersList(RequirementsXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementsXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswers(RequirementsXmlParser.PossibleAnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementsXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswers(RequirementsXmlParser.PossibleAnswersContext ctx);
}