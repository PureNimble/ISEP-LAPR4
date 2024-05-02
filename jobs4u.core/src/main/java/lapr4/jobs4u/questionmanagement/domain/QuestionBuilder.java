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

    public QuestionBuilder with(final QuestionType type, final String body, final List<Answer> possibleAnswers) {
        this.withType(type);
        this.withBody(body);
        this.withPossibleAnswers(possibleAnswers);

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

    @Override
    public Question build() {
        final Question question = new Question(this.type, this.body, this.possibleAnswers);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new question [{}] {} {} {}", question, this.type, this.body, this.possibleAnswers);
        }
        return question;
    }
}
