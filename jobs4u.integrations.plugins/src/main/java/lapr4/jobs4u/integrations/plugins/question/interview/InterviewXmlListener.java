package lapr4.jobs4u.integrations.plugins.question.interview;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.xml.generated.InterviewXmlBaseListener;
import lapr4.jobs4u.importer.xml.generated.InterviewXmlParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;

public class InterviewXmlListener extends InterviewXmlBaseListener {

    private final List<InterviewQuestionDTO> questions = new ArrayList<>();
    private InterviewQuestionDTO current;

    @Override
    public void enterQuestion(final InterviewXmlParser.QuestionContext ctx) {
        current = new InterviewQuestionDTO();
    }

    @Override
    public void exitQuestion(final InterviewXmlParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterBody(final InterviewXmlParser.BodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterCotation(final InterviewXmlParser.CotationContext ctx) {
        current.setCotation(extractValue(ctx));
    }

    @Override
    public void enterCotationType(final InterviewXmlParser.CotationTypeContext ctx) {
        current.setCotationType(extractValue(ctx));
    }

    @Override
    public void enterType(final InterviewXmlParser.TypeContext ctx) {
        current.setType(extractValue(ctx));
    }

    @Override
    public void enterPossibleAnswersList(final InterviewXmlParser.PossibleAnswersListContext ctx) {
        List<Answer> answers = new ArrayList<>();
        for (InterviewXmlParser.PossibleAnswersContext answerContext : ctx.possibleAnswers()) {
            String value = extractValue(answerContext);
            answers.add(Answer.valueOf(value));
        }
        current.setPossibleAnswers(answers);
    }

    private String extractValue(ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText.replaceAll("<[^>]+>", "").trim();
    }

    public List<InterviewQuestionDTO> questions() {
        return questions;
    }
}
