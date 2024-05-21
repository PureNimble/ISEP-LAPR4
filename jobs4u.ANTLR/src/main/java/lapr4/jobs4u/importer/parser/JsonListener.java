package lapr4.jobs4u.importer.parser;
// Generated from Json.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonParser}.
 */
public interface JsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(JsonParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(JsonParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(JsonParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(JsonParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(JsonParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(JsonParser.QuestionContext ctx);
}