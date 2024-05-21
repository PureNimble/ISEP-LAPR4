package lapr4.jobs4u.importer.parser;
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
	 * Visit a parse tree produced by {@link JsonParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(JsonParser.QuestionContext ctx);
}