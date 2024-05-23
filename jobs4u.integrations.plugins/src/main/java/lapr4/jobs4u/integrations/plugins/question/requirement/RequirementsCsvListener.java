package lapr4.jobs4u.integrations.plugins.question.requirement;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.csv.generated.requirement.RequirementsCsvBaseListener;
import lapr4.jobs4u.importer.csv.generated.requirement.RequirementsCsvParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

public class RequirementsCsvListener extends RequirementsCsvBaseListener {

    private final List<RequirementsQuestionDTO> questions = new ArrayList<>();
    private RequirementsQuestionDTO current;

    @Override
    public void enterQuestion(final RequirementsCsvParser.QuestionContext ctx) {
        current = new RequirementsQuestionDTO();
    }

    @Override
    public void exitQuestion(final RequirementsCsvParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterQuestionBody(final RequirementsCsvParser.QuestionBodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterAnswer(final RequirementsCsvParser.AnswerContext ctx) {
        final String value = extractValue(ctx);
        final String[] answer = value.split("/");
        final List<Answer> answers = new ArrayList<>();
        for (String ans : answer) {
            answers.add(Answer.valueOf(ans));
        }
        current.setPossibleAnswers(answers);
    }

    private String extractValue(ParserRuleContext ctx) {
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
