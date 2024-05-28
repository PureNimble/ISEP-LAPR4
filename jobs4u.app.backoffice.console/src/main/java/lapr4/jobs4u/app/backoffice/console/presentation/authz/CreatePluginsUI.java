package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;
import java.util.Arrays;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.importer.application.ImportQuestionsController;
import lapr4.jobs4u.integration.questions.importer.application.RegisterQuestionImporterPluginController;
import lapr4.jobs4u.integration.questions.importer.domain.PluginType;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.domain.TypesOfPlugins;

/**
 * @author 2DI2
 */
public class CreatePluginsUI extends AbstractUI {

    private static final String INTERVIEW_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter";
    private static final String REQUIREMENTS_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.requirement.RequirementsImporter";
    private static final String PATH = "jobs4u.ANTLR/src/main/resources/input/";

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final RegisterQuestionImporterPluginController theController = new RegisterQuestionImporterPluginController(
            PersistenceContext.repositories().questionImporterPlugins(txCtx), AuthzRegistry.authorizationService());
    private final ImportQuestionsController importQuestionsController = new ImportQuestionsController(
            PersistenceContext.repositories().questionImporterPlugins(),
            PersistenceContext.repositories().interviewQuestion(),
            PersistenceContext.repositories().requirementsQuestion(),
            PersistenceContext.repositories().questionType(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        final String name = Console.readLine("Plugin Name: ");
        final String description = Console.readLine("Description: ");
        final String fileExtension = Console.readLine("File Extension: ");
        final Object pluginTypeObj = Utils.showAndSelectOne(Arrays.asList(TypesOfPlugins.values()),
                "Select the plugin type:");
        if (pluginTypeObj == null) {
            System.out.println("No plugin type selected.");
            return false;
        }
        final String pluginType = pluginTypeObj.toString();
        if (pluginType == null)
            return false;
        try {
            txCtx.beginTransaction();
            final String file = PATH + name + "." + fileExtension;
            if (pluginType.equals(PluginType.valueOf(TypesOfPlugins.INTERVIEW.toString()))) {
                QuestionImporterPlugin plugin = this.theController.registerQuestionImporterPlugin(name, description,
                        fileExtension, INTERVIEW_IMPORTER, pluginType);
                this.importQuestionsController.importInterviewQuestions(file, plugin);
            } else {
                QuestionImporterPlugin plugin = this.theController.registerQuestionImporterPlugin(name, description,
                        fileExtension, REQUIREMENTS_IMPORTER, pluginType);
                this.importQuestionsController.importRequirementsQuestions(file, plugin);
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException | IOException e) {
            txCtx.rollback();
            System.out.println("You tried to enter a plugin that already exists in the system.\n" + e.getMessage());
        } finally {
            txCtx.close();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Plugins";
    }
}
