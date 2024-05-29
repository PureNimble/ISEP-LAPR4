package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.exporter.application.FileFormat;
import lapr4.jobs4u.integration.questions.exporter.application.QuestionExporterController;
import lapr4.jobs4u.integration.questions.importer.application.ListQuestionPluginController;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;

/**
 * @author 2DI2
 */
public class ExportRequirementUI extends AbstractUI {

    private static final String PATH = "jobs4u.ANTLR/src/main/resources/input/template/";
    private final QuestionExporterController questionExporterController = new QuestionExporterController();
    private final ListQuestionPluginController listQuestionPluginController = new ListQuestionPluginController(
            PersistenceContext.repositories().questionImporterPlugins(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        Iterable<QuestionImporterPlugin> questionImporterPlugins = listQuestionPluginController
                .filterByType(FileFormat.REQUIREMENT.toString());

        final QuestionImporterPlugin questionImporterPlugin = (QuestionImporterPlugin) Utils
                .showAndSelectOne(questionImporterPlugins, "Plugins");

        if (questionImporterPlugin == null) {
            return false;
        }

        try {
            final String filename = PATH + questionImporterPlugin.identity().toString() + ".txt";
            this.questionExporterController.exportRequirements(filename, FileFormat.REQUIREMENT,
                    questionImporterPlugin);
        } catch (final IntegrityViolationException | IOException | ConcurrencyException e) {
            System.out.println("Something went wrong.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Generate Requirement Teamplate";
    }
}