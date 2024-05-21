package lapr4.jobs4u.importer.csv.parser;
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
	 * Visit a parse tree produced by {@link CsvParser#questionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionBody(CsvParser.QuestionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CsvParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(CsvParser.AnswerContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link CsvParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(CsvParser.CotationTypeContext ctx);
}