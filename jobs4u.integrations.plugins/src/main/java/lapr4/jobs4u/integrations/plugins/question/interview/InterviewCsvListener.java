package lapr4.jobs4u.integrations.plugins.question.interview;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import lapr4.jobs4u.importer.csv.generated.interview.InterviewCsvBaseListener;
import lapr4.jobs4u.importer.csv.generated.interview.InterviewCsvParser;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.dto.InterviewQuestionDTO;

public class InterviewCsvListener extends InterviewCsvBaseListener {

    private final List<InterviewQuestionDTO> questions = new ArrayList<>();
    private InterviewQuestionDTO current;

    @Override
    public void enterQuestion(final InterviewCsvParser.QuestionContext ctx) {
        current = new InterviewQuestionDTO();
    }

    @Override
    public void exitQuestion(final InterviewCsvParser.QuestionContext ctx) {
        questions.add(current);
    }

    @Override
    public void enterQuestionBody(final InterviewCsvParser.QuestionBodyContext ctx) {
        current.setBody(extractValue(ctx));
    }

    @Override
    public void enterCotation(final InterviewCsvParser.CotationContext ctx) {
        current.setCotation(extractValue(ctx));
    }

    @Override
    public void enterCotationType(final InterviewCsvParser.CotationTypeContext ctx) {
        current.setCotationType(extractValue(ctx));
    }

    @Override
    public void enterType(final InterviewCsvParser.TypeContext ctx) {
        current.setType(extractValue(ctx));
    }

    @Override
    public void enterAnswer(final InterviewCsvParser.AnswerContext ctx) {
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

    public List<InterviewQuestionDTO> questions() {
        return questions;
    }
}
