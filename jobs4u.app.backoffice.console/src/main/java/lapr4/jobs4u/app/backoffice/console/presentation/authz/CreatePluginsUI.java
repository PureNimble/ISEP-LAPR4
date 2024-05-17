package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;
import java.util.Arrays;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.integration.questions.import_.application.ImportQuestionsController;
import lapr4.jobs4u.integration.questions.import_.application.RegisterQuestionImporterPluginController;
import lapr4.jobs4u.integration.questions.import_.domain.TypesOfPlugins;

public class CreatePluginsUI extends AbstractUI {

    private final RegisterQuestionImporterPluginController theController = new RegisterQuestionImporterPluginController();
    private final ImportQuestionsController importQuestionsController = new ImportQuestionsController();

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
        String fqClassName = "";
        if (pluginType == null)
            return false;
        if (pluginType.equals(TypesOfPlugins.INTERVIEW.toString())) {
            fqClassName = "lapr4.jobs4u.integrations.plugins.question.interview.InterviewImporter";
        } else
            fqClassName = "lapr4.jobs4u.integrations.plugins.question.requirement.RequirementImporter";
        try {
            this.theController.registerQuestionImporterPlugin(name, description, fileExtension, fqClassName,
                    pluginType);
            final String file = name + "." + fileExtension;
            this.importQuestionsController.importQuestions(file);
        } catch (final IntegrityViolationException | ConcurrencyException | IOException e) {
            System.out.println("You tried to enter a plugin that already exists in the system.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Plugins";
    }
}
