package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;

/**
 * @author 2DI2
 */
public class InMemoryInterviewQuestionRepository
        extends InMemoryDomainRepository<InterviewQuestion, Long>
        implements InterviewQuestionRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<InterviewQuestion> findAll() {
        return match(e -> true);
    }

    @Override
    public Iterable<InterviewQuestion> findQuestionsByPlugin(final QuestionImporterPlugin plugin) {
        return match(e -> e.importerPlugin().equals(plugin));
    }
}