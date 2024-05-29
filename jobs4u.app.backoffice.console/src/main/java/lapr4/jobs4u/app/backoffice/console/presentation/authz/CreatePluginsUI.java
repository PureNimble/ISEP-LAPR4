package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;
import java.nio.file.Path;
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
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.integration.questions.importer.domain.TypesOfPlugins;

/**
 * @author 2DI2
 */
public class CreatePluginsUI extends AbstractUI {

    private static final String INTERVIEW_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter";
    private static final String REQUIREMENTS_IMPORTER = "lapr4.jobs4u.integrations.plugins.question.requirement.RequirementsImporter";
    private static final String OUTPUT_FOLDER = "jobs4u.ANTLR/src/main/resources/input/template/";

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final RegisterQuestionImporterPluginController theController = new RegisterQuestionImporterPluginController(
            PersistenceContext.repositories().questionImporterPlugins(txCtx), AuthzRegistry.authorizationService());
    private final ImportQuestionsController importQuestionsController = new ImportQuestionsController(
            PersistenceContext.repositories().questionImporterPlugins(),
            PersistenceContext.repositories().interviewQuestion(txCtx),
            PersistenceContext.repositories().requirementsQuestion(txCtx),
            PersistenceContext.repositories().questionType(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final Path file = Utils.getPath(false);
        if (file == null)
            return false;
        final String finalPath = OUTPUT_FOLDER + file.getFileName().toString();
        if (!Utils.copyFile(file, finalPath))
            return false;

        final String description = Console.readLine("Description: ");
        final String fullName = file.getFileName().toString();
        final String name = fullName.substring(0, fullName.lastIndexOf('.'));
        final String fileExtension = fullName.substring(fullName.lastIndexOf('.') + 1);
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
            if (pluginType.equals(TypesOfPlugins.INTERVIEW.toString())) {
                final QuestionImporterPlugin plugin = this.theController.registerQuestionImporterPlugin(name,
                        description, fileExtension, INTERVIEW_IMPORTER, pluginType);
                this.importQuestionsController.importInterviewQuestions(finalPath, plugin);
            } else {
                final QuestionImporterPlugin plugin = this.theController.registerQuestionImporterPlugin(name,
                        description, fileExtension, REQUIREMENTS_IMPORTER, pluginType);
                this.importQuestionsController.importRequirementsQuestions(finalPath, plugin);
            }
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException | IOException e) {
            txCtx.rollback();
            System.out.println("Something went wrong: " + e.getMessage());
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
