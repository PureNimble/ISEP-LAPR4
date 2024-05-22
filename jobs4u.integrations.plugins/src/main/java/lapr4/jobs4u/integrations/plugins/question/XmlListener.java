package lapr4.jobs4u.integrations.plugins.question;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.xml.parser.XmlBaseListener;
import lapr4.jobs4u.importer.xml.parser.XmlParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

public class XmlListener extends XmlBaseListener {

    private final List<QuestionDTO> questions = new ArrayList<>();
    private QuestionDTO current;

    @Override
    public void enterQuestion(final XmlParser.QuestionContext ctx) {
        current = new QuestionDTO();
    }

    @Override
    public void exitQuestion(final XmlParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterBody(final XmlParser.BodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterCotation(final XmlParser.CotationContext ctx) {
        current.setCotation(extractValue(ctx));
    }

    @Override
    public void enterCotationType(final XmlParser.CotationTypeContext ctx) {
        current.setCotationType(extractValue(ctx));
    }

    @Override
    public void enterType(final XmlParser.TypeContext ctx) {
        current.setType(extractValue(ctx));
    }

    @Override
    public void enterPossibleAnswersList(final XmlParser.PossibleAnswersListContext ctx) {
        List<Answer> answers = new ArrayList<>();
        for (XmlParser.PossibleAnswersContext answerContext : ctx.possibleAnswers()) {
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

    public List<QuestionDTO> questions() {
        return questions;
    }
}
