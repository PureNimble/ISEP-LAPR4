package lapr4.jobs4u.importer.parser;
// Generated from Csv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CsvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CsvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CsvParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(CsvParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(CsvParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(CsvParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(CsvParser.CotationContext ctx);
}