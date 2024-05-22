package lapr4.jobs4u.integrations.plugins.question;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.csv.parser.CsvBaseListener;
import lapr4.jobs4u.importer.csv.parser.CsvParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.QuestionDTO;

public class CsvListener extends CsvBaseListener {

    private final List<QuestionDTO> questions = new ArrayList<>();
    private QuestionDTO current;

    @Override
    public void enterQuestion(final CsvParser.QuestionContext ctx) {
        current = new QuestionDTO();
    }

    @Override
    public void exitQuestion(final CsvParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterQuestionBody(final CsvParser.QuestionBodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterCotation(final CsvParser.CotationContext ctx) {
        current.setCotation(extractValue(ctx));
    }

    @Override
    public void enterCotationType(final CsvParser.CotationTypeContext ctx) {
        current.setCotationType(extractValue(ctx));
    }

    @Override
    public void enterType(final CsvParser.TypeContext ctx) {
        current.setType(extractValue(ctx));
    }

    @Override
    public void enterAnswer(final CsvParser.AnswerContext ctx) {
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

    public List<QuestionDTO> questions() {
        return questions;
    }
}
