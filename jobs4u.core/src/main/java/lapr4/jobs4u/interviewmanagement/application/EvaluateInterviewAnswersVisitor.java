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
        question = extractValue(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitType(final InterviewAnswersParser.TypeContext ctx) {
        visitText(ctx.text());
        if (ctx.choice() != null)
            visitChoice(ctx.choice());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitChoice(final InterviewAnswersParser.ChoiceContext ctx) {
        if (ctx.getText() != null) {
            question += " " + extractValue(ctx).replace("\n", " ").replace("\r", "");
        }

        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitAnswer(final InterviewAnswersParser.AnswerContext ctx) {
        final String answer = extractValue(ctx);
        question = question.trim();
        answers.put(QuestionBody.valueOf(question), Answer.valueOf(answer));
        return answers;
    }

    private String extractValue(final ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText;
    }
}