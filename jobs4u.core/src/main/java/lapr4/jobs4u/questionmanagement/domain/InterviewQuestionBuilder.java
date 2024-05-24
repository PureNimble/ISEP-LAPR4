package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterviewQuestionBuilder implements DomainFactory<InterviewQuestion> {

    private static final Logger LOGGER = LogManager.getLogger(InterviewQuestionBuilder.class);
    private QuestionType type;
    private Cotation cotation;
    private CotationType cotationType;
    private QuestionBody body;
    private List<InterviewAnswer> possibleAnswers;
    private String importerPlugin;

    public InterviewQuestionBuilder with(final QuestionType type, final String cotation, final String cotationType, final String body, final List<InterviewAnswer> possibleAnswers, final String importerPlugin) {
        this.withType(type);
        this.withCotation(cotation);
        this.withCotationType(cotationType);
        this.withBody(body);
        this.withPossibleAnswers(possibleAnswers);
        this.withImporterPlugin(importerPlugin);
        return this;
    }

    public InterviewQuestionBuilder withType(final QuestionType type) {
        this.type = type;
        return this;
    }

    public InterviewQuestionBuilder withCotation(final String cotation) {
        if (cotation != null) {
            this.cotation = Cotation.valueOf(cotation);
        } else this.cotation = null;
        return this;
    }

    public InterviewQuestionBuilder withCotationType(final String cotationType) {
        if (cotationType != null) {
            this.cotationType = CotationType.valueOf(cotationType);
        } else this.cotationType = null;
        return this;
    }

    public InterviewQuestionBuilder withBody(final String body) {
        this.body = QuestionBody.valueOf(body);
        return this;
    }

    public InterviewQuestionBuilder withPossibleAnswers(final List<InterviewAnswer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
        return this;
    }

    public InterviewQuestionBuilder withImporterPlugin(final String importerPlugin) {
        this.importerPlugin = importerPlugin;
        return this;
    }

    @Override
    public InterviewQuestion build() {
        final InterviewQuestion question = new InterviewQuestion(this.type, this.cotation, this.cotationType, this.body, this.possibleAnswers, this.importerPlugin);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new question [{}] {} {} {} {} {} {}", question, this.type, this.cotation, this.cotationType, this.body, this.possibleAnswers, this.importerPlugin);
        }
        return question;
    }
}
