package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 2DI2
 */
public class RequirementsQuestionBuilder implements DomainFactory<RequirementsQuestion> {

    private static final Logger LOGGER = LogManager.getLogger(RequirementsQuestionBuilder.class);
    private QuestionBody body;
    private List<Answer> possibleAnswers;
    private String importerPlugin;

    public RequirementsQuestionBuilder with(final String body, final List<Answer> possibleAnswers, final String importerPlugin) {
        this.withBody(body);
        this.withPossibleAnswers(possibleAnswers);
        this.withImporterPlugin(importerPlugin);
        return this;
    }

    public RequirementsQuestionBuilder withBody(final String body) {
        this.body = QuestionBody.valueOf(body);
        return this;
    }

    public RequirementsQuestionBuilder withPossibleAnswers(final List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
        return this;
    }

    public RequirementsQuestionBuilder withImporterPlugin(final String importerPlugin) {
        this.importerPlugin = importerPlugin;
        return this;
    }

    @Override
    public RequirementsQuestion build() {
        final RequirementsQuestion question = new RequirementsQuestion(this.body, this.possibleAnswers, this.importerPlugin);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new question [{}] {} {} {}", question, this.body, this.possibleAnswers, this.importerPlugin);
        }
        return question;
    }
}