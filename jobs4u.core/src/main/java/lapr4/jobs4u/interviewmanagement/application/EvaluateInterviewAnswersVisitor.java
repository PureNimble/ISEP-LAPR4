package lapr4.jobs4u.interviewmanagement.application;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersBaseVisitor;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.QuestionBody;

/**
 * @author 2DI2
 */
public class EvaluateInterviewAnswersVisitor extends InterviewAnswersBaseVisitor<Map<QuestionBody, Answer>> {

    private Map<QuestionBody, Answer> answers = new HashMap<>();
    private String question;

    @Override
    public Map<QuestionBody, Answer> visitStart(final InterviewAnswersParser.StartContext ctx) {
        visitChildren(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitContent(final InterviewAnswersParser.ContentContext ctx) {
        visitChildren(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitText(final InterviewAnswersParser.TextContext ctx) {
        question = extractQuestion(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitType(final InterviewAnswersParser.TypeContext ctx) {
        if (ctx.true_false() != null) {
            visitTrue_false(ctx.true_false());
        } else if (ctx.short_text_answer() != null) {
            visitShort_text_answer(ctx.short_text_answer());
        } else if (ctx.integer_number() != null) {
            visitInteger_number(ctx.integer_number());
        } else if (ctx.decimal_number() != null) {
            visitDecimal_number(ctx.decimal_number());
        } else if (ctx.date() != null) {
            visitDate(ctx.date());
        } else if (ctx.time() != null) {
            visitTime(ctx.time());
        } else if (ctx.numeric_scale() != null) {
            visitNumeric_scale(ctx.numeric_scale());
        } else if (ctx.single_answer_choice() != null) {
            visitSingle_answer_choice(ctx.single_answer_choice());
        } else if (ctx.multiple_answer_choice() != null) {
            visitMultiple_answer_choice(ctx.multiple_answer_choice());
        }
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitTrue_false(final InterviewAnswersParser.True_falseContext ctx) {
        visitQuestion(ctx.question());
        visitTrue_false_answer(ctx.true_false_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitShort_text_answer(final InterviewAnswersParser.Short_text_answerContext ctx) {
        visitQuestion(ctx.question());
        visitText_answer(ctx.text_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitInteger_number(final InterviewAnswersParser.Integer_numberContext ctx) {
        visitQuestion(ctx.question());
        visitInteger_answer(ctx.integer_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitDecimal_number(final InterviewAnswersParser.Decimal_numberContext ctx) {
        visitQuestion(ctx.question());
        visitDecimal_answer(ctx.decimal_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitDate(final InterviewAnswersParser.DateContext ctx) {
        visitQuestion(ctx.question());
        visitDate_answer(ctx.date_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitTime(final InterviewAnswersParser.TimeContext ctx) {
        visitQuestion(ctx.question());
        visitTime_answer(ctx.time_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitNumeric_scale(final InterviewAnswersParser.Numeric_scaleContext ctx) {
        visitQuestion(ctx.question());
        visitNumeric_scale_answer(ctx.numeric_scale_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitSingle_answer_choice(
            final InterviewAnswersParser.Single_answer_choiceContext ctx) {
        visitQuestion(ctx.question());
        visitChoice(ctx.choice());
        visitSingle_answer_choice_answer(ctx.single_answer_choice_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitMultiple_answer_choice(
            final InterviewAnswersParser.Multiple_answer_choiceContext ctx) {
        visitQuestion(ctx.question());
        visitChoice(ctx.choice());
        visitMultiple_answer_choice_answer(ctx.multiple_answer_choice_answer());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitQuestion(final InterviewAnswersParser.QuestionContext ctx) {
        visitText(ctx.text());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitTrue_false_answer(final InterviewAnswersParser.True_false_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitText_answer(final InterviewAnswersParser.Text_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitSingle_answer_choice_answer(
            final InterviewAnswersParser.Single_answer_choice_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitMultiple_answer_choice_answer(
            final InterviewAnswersParser.Multiple_answer_choice_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitInteger_answer(final InterviewAnswersParser.Integer_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitDecimal_answer(final InterviewAnswersParser.Decimal_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitDate_answer(final InterviewAnswersParser.Date_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitTime_answer(final InterviewAnswersParser.Time_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitNumeric_scale_answer(
            final InterviewAnswersParser.Numeric_scale_answerContext ctx) {
        final String answer = extractAnswer(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitChoice(final InterviewAnswersParser.ChoiceContext ctx) {
        if (ctx.getText() != null) {
            question += " " + extractQuestion(ctx).replace("\n", " ").replace("\r", "");
        }

        return answers;
    }

    private String extractQuestion(final ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText;
    }

    private String extractAnswer(final ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        String intervalText = ctx.start.getInputStream().getText(interval);
        intervalText = intervalText.replaceFirst("ANSWER: ", "");
        return intervalText;
    }
}