package lapr4.jobs4u.integrations.plugins.question.requirement;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.xml.generated.requirement.RequirementsXmlBaseListener;
import lapr4.jobs4u.importer.xml.generated.requirement.RequirementsXmlParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.RequirementsQuestionDTO;

public class RequirementsXmlListener extends RequirementsXmlBaseListener {

    private final List<RequirementsQuestionDTO> questions = new ArrayList<>();
    private RequirementsQuestionDTO current;

    @Override
    public void enterQuestion(final RequirementsXmlParser.QuestionContext ctx) {
        current = new RequirementsQuestionDTO();
    }

    @Override
    public void exitQuestion(final RequirementsXmlParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterBody(final RequirementsXmlParser.BodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterPossibleAnswersList(final RequirementsXmlParser.PossibleAnswersListContext ctx) {
        List<Answer> answers = new ArrayList<>();
        for (RequirementsXmlParser.PossibleAnswersContext answerContext : ctx.possibleAnswers()) {
            String value = extractValue(answerContext);
            answers.add(Answer.valueOf(value));
        }
        current.setPossibleAnswers(answers);
    }

    private String extractValue(final ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText.replaceAll("<[^>]+>", "").trim();
    }

    public List<RequirementsQuestionDTO> questions() {
        return questions;
    }
}
