package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;

/**
 * @author 2DI2
 */
public class InMemoryRequirementsQuestionRepository extends InMemoryDomainRepository<RequirementsQuestion, Long>
        implements RequirementsQuestionRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<RequirementsQuestion> findAll() {
        return match(e -> true);
    }

    @Override
    public Iterable<RequirementsQuestion> findQuestionsByPlugin(final QuestionImporterPlugin plugin) {
        return match(e -> e.importerPlugin().equals(plugin));
    }
}