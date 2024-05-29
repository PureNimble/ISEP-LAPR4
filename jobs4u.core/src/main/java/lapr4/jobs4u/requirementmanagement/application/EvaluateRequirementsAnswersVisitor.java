package lapr4.jobs4u.requirementmanagement.application;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.requirement.answer.generated.RequirementsAnswersBaseVisitor;
import lapr4.jobs4u.importer.requirement.answer.generated.RequirementsAnswersParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.QuestionBody;

/**
 * @author 2DI2
 */
public class EvaluateRequirementsAnswersVisitor extends RequirementsAnswersBaseVisitor<Map<QuestionBody, Answer>> {

    private Map<QuestionBody, Answer> answers = new HashMap<>();
    private String question;

    @Override
    public Map<QuestionBody, Answer> visitStart(final RequirementsAnswersParser.StartContext ctx) {
        visitChildren(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitContent(final RequirementsAnswersParser.ContentContext ctx) {
        visitChildren(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitQuestion(final RequirementsAnswersParser.QuestionContext ctx) {
        visitText(ctx.text());
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitText(final RequirementsAnswersParser.TextContext ctx) {
        question = extractValue(ctx);
        return answers;
    }

    @Override
    public Map<QuestionBody, Answer> visitAnswer(final RequirementsAnswersParser.AnswerContext ctx) {
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