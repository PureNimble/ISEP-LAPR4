package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.integration.questions.importer.domain.FileExtension;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;

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

    @Override
    public Iterable<QuestionImporterPlugin> findByPluginType(final PluginType pluginType) {
        return match(e -> e.pluginType().equals(pluginType));
    }

    @Override
    public Optional<QuestionImporterPlugin> findByName(final Designation name) {
        return matchOne(e -> e.identity().equals(name));
    }
}