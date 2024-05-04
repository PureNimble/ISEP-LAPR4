package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestionBuilder implements DomainFactory<Question> {

    private static final Logger LOGGER = LogManager.getLogger(QuestionBuilder.class);
    private QuestionType type;
    private QuestionBody body;
    private List<Answer> possibleAnswers;
    private String importerPlugin;

    public QuestionBuilder with(final QuestionType type, final String body, final List<Answer> possibleAnswers, final String importerPlugin) {
        this.withType(type);
        this.withBody(body);
        this.withPossibleAnswers(possibleAnswers);
        this.withImporterPlugin(importerPlugin);

        return this;
    }

    public QuestionBuilder withType(final QuestionType type) {
        this.type = type;
        return this;
    }

    public QuestionBuilder withBody(final String body) {
        this.body = QuestionBody.valueOf(body);
        return this;
    }

    public QuestionBuilder withPossibleAnswers(final List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
        return this;
    }

    public QuestionBuilder withImporterPlugin(final String importerPlugin) {
        this.importerPlugin = importerPlugin;
        return this;
    }

    @Override
    public Question build() {
        final Question question = new Question(this.type, this.body, this.possibleAnswers, this.importerPlugin);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new question [{}] {} {} {} {}", question, this.type, this.body, this.possibleAnswers, this.importerPlugin);
        }
        return question;
    }
}
