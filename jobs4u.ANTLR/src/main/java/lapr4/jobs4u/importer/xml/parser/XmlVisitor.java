package lapr4.jobs4u.importer.xml.parser;
// Generated from Xml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XmlParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(XmlParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(XmlParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(XmlParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(XmlParser.CotationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(XmlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(XmlParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#possibleAnswersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswersList(XmlParser.PossibleAnswersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link XmlParser#possibleAnswers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswers(XmlParser.PossibleAnswersContext ctx);
}