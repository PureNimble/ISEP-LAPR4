package lapr4.jobs4u.integration.questions.importer.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

/**
 * @author 2DI2
 */
public class QuestionImporterPluginBuilder implements DomainFactory<QuestionImporterPlugin> {

    private static final Logger LOGGER = LogManager.getLogger(QuestionImporterPluginBuilder.class);

    private Designation name;
    private Description description;
    private FileExtension fileExtension;
    private FQClassName className;
    private PluginType pluginType;

    public QuestionImporterPluginBuilder with(final String name, final String description, final String fileExtension,
            final String fqClassName, final String pluginType) {
        this.withName(name);
        this.withDescription(description);
        this.withFileExtension(fileExtension);
        this.withClassName(fqClassName);
        this.withPluginType(pluginType);
        return this;
    }

    public QuestionImporterPluginBuilder withName(final String name) {
        this.name = Designation.valueOf(name);
        return this;
    }

    public QuestionImporterPluginBuilder withDescription(final String description) {
        this.description = Description.valueOf(description);
        return this;
    }

    public QuestionImporterPluginBuilder withFileExtension(final String fileExtension) {
        this.fileExtension = FileExtension.valueOf(fileExtension);
        return this;
    }

    public QuestionImporterPluginBuilder withClassName(final String fqClassName) {
        this.className = FQClassName.valueOf(fqClassName);
        return this;
    }

    public QuestionImporterPluginBuilder withPluginType(final String pluginType) {
        this.pluginType = PluginType.valueOf(pluginType);
        return this;
    }

    @Override
    public QuestionImporterPlugin build() {
        final QuestionImporterPlugin questionImporterPlugin = new QuestionImporterPlugin(this.name,
                this.description, this.fileExtension, this.className, this.pluginType);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Question Importer Plugin [{}] {} {} {} {} {}", questionImporterPlugin, this.name,
                    this.description, this.fileExtension, this.className, this.pluginType);
        }
        return questionImporterPlugin;
    }
}
