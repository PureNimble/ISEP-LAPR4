package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.integration.questions.import_.domain.FileExtension;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.import_.repositories.QuestionImporterPluginRepository;

public class InMemoryQuestionImporterPluginRepository
        extends InMemoryDomainRepository<QuestionImporterPlugin, Designation>
        implements QuestionImporterPluginRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<QuestionImporterPlugin> findAll() {
        return match(e -> true);
    }

    @Override
    public Optional<QuestionImporterPlugin> findByFileExtension(final FileExtension fileExtension) {
        return matchOne(e -> e.fileExtension().equals(fileExtension));
    }
}