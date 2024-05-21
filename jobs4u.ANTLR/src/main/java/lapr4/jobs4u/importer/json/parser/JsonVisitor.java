package lapr4.jobs4u.importer.json.parser;
// Generated from Json.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(JsonParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(JsonParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(JsonParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JsonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(JsonParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(JsonParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(JsonParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(JsonParser.CotationTypeContext ctx);
}