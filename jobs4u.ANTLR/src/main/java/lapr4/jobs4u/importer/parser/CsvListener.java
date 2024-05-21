package lapr4.jobs4u.importer.parser;
// Generated from Csv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CsvParser}.
 */
public interface CsvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(CsvParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CsvParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(CsvParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CsvParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(CsvParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CsvParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(CsvParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CsvParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(CsvParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CsvParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(CsvParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CsvParser#cotation}.
	 * @param ctx the parse tree
	 */
	void enterCotation(CsvParser.CotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CsvParser#cotation}.
	 * @param ctx the parse tree
	 */
	void exitCotation(CsvParser.CotationContext ctx);
}