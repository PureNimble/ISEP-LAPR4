package lapr4.jobs4u.importer.xml.generated.requirement;
// Generated from RequirementsXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsXmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsXmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(RequirementsXmlParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(RequirementsXmlParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(RequirementsXmlParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(RequirementsXmlParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswersList(RequirementsXmlParser.PossibleAnswersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsXmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswers(RequirementsXmlParser.PossibleAnswersContext ctx);
}