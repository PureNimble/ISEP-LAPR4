package lapr4.jobs4u.integrations.plugins.question.requirement;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.json.generated.requirement.RequirementsJsonBaseListener;
import lapr4.jobs4u.importer.json.generated.requirement.RequirementsJsonParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

/**
 * @author 2DI2
 */
public class RequirementsJsonListener extends RequirementsJsonBaseListener {

    private final List<RequirementsQuestionDTO> questions = new ArrayList<>();
    private RequirementsQuestionDTO current;
    private List<Answer> answers = new ArrayList<>();

    @Override
    public void enterQuestion(final RequirementsJsonParser.QuestionContext ctx) {
        current = new RequirementsQuestionDTO();
    }

    @Override
    public void exitQuestion(final RequirementsJsonParser.QuestionContext ctx) {
        current.setPossibleAnswers(answers);
        answers = new ArrayList<>();
        questions.add(current);
    }

    @Override
    public void enterQuestionBody(final RequirementsJsonParser.QuestionBodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterAnswer(final RequirementsJsonParser.AnswerContext ctx) {
        final String value = extractValue(ctx);
        answers.add(Answer.valueOf(value));
    }

    private String extractValue(final ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText.substring(1, intervalText.length() - 1);
    }

    public List<RequirementsQuestionDTO> questions() {
        return questions;
    }
}
