package lapr4.jobs4u.integration.questions.importer.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import eapli.framework.general.domain.model.Designation;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.repositories.QuestionImporterPluginRepository;

/**
 * @author 2DI2
 */
@Component
public class ListQuestionPluginService {

    private final QuestionImporterPluginRepository questionImporterPluginRepository;

    public ListQuestionPluginService(QuestionImporterPluginRepository questionImporterPluginRepository) {
        this.questionImporterPluginRepository = questionImporterPluginRepository;
    }

    public Iterable<QuestionImporterPlugin> filterByType(final PluginType plugin) {
        return this.questionImporterPluginRepository.findByPluginType(plugin);
    }

    public Optional<QuestionImporterPlugin> filterByDesignation(final Designation plugin) {
        return this.questionImporterPluginRepository.findByName(plugin);
    }
}
