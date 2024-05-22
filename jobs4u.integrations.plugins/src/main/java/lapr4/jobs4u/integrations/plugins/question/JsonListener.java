package lapr4.jobs4u.integrations.plugins.question;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.json.parser.JsonBaseListener;
import lapr4.jobs4u.importer.json.parser.JsonParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

public class JsonListener extends JsonBaseListener {

    private final List<QuestionDTO> questions = new ArrayList<>();
    private QuestionDTO current;
    private List<Answer> answers = new ArrayList<>();

    @Override
    public void enterQuestion(final JsonParser.QuestionContext ctx) {
        current = new QuestionDTO();
    }

    @Override
    public void exitQuestion(final JsonParser.QuestionContext ctx) {
        current.setPossibleAnswers(answers);
        answers = new ArrayList<>();
        questions.add(current);
    }

    @Override
    public void enterQuestionBody(final JsonParser.QuestionBodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterCotation(final JsonParser.CotationContext ctx) {
        current.setCotation(extractValue(ctx));
    }

    @Override
    public void enterCotationType(final JsonParser.CotationTypeContext ctx) {
        current.setCotationType(extractValue(ctx));
    }

    @Override
    public void enterType(final JsonParser.TypeContext ctx) {
        current.setType(extractValue(ctx));
    }

    @Override
    public void enterAnswer(final JsonParser.AnswerContext ctx) {
        final String value = extractValue(ctx);
        answers.add(Answer.valueOf(value));
    }

    private String extractValue(ParserRuleContext ctx) {
        final Token startToken = ctx.getStart();
        final Token stopToken = ctx.getStop();
        final Interval interval = new Interval(startToken.getStartIndex(), stopToken.getStopIndex());
        final String intervalText = ctx.start.getInputStream().getText(interval);
        return intervalText.substring(1, intervalText.length() - 1);
    }

    public List<QuestionDTO> questions() {
        return questions;
    }
}
