package lapr4.jobs4u.importer.interview.answer.generated;
// Generated from InterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewAnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewAnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewAnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(InterviewAnswersParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#cotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotation(InterviewAnswersParser.CotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#cotationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotationType(InterviewAnswersParser.CotationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(InterviewAnswersParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(InterviewAnswersParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(InterviewAnswersParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(InterviewAnswersParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewAnswersParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InterviewAnswersParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#true_false}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false(InterviewAnswersParser.True_falseContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#short_text_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_text_answer(InterviewAnswersParser.Short_text_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#single_answer_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_answer_choice(InterviewAnswersParser.Single_answer_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#multiple_answer_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_answer_choice(InterviewAnswersParser.Multiple_answer_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#integer_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_number(InterviewAnswersParser.Integer_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#decimal_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_number(InterviewAnswersParser.Decimal_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(InterviewAnswersParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(InterviewAnswersParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#numeric_scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_scale(InterviewAnswersParser.Numeric_scaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#true_false_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_answer(InterviewAnswersParser.True_false_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#text_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_answer(InterviewAnswersParser.Text_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#integer_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_answer(InterviewAnswersParser.Integer_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#decimal_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_answer(InterviewAnswersParser.Decimal_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#date_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_answer(InterviewAnswersParser.Date_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#time_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_answer(InterviewAnswersParser.Time_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#numeric_scale_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_scale_answer(InterviewAnswersParser.Numeric_scale_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#single_answer_choice_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_answer_choice_answer(InterviewAnswersParser.Single_answer_choice_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewAnswersParser#multiple_answer_choice_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_answer_choice_answer(InterviewAnswersParser.Multiple_answer_choice_answerContext ctx);
}