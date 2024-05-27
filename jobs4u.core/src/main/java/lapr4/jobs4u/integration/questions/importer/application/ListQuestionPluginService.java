package lapr4.jobs4u.integration.questions.importer.application;

import org.springframework.stereotype.Component;

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
}
