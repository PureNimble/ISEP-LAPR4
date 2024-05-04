package lapr4.jobs4u.integration.questions.import_.application;

import org.springframework.stereotype.Component;

import lapr4.jobs4u.integration.questions.import_.domain.PluginType;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.import_.repositories.QuestionImporterPluginRepository;

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
