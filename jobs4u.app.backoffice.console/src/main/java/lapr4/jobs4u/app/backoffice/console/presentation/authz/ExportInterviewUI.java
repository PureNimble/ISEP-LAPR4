package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.IOException;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.export.application.FileFormat;
import lapr4.jobs4u.integration.questions.export.application.QuestionExporterController;
import lapr4.jobs4u.integration.questions.import_.application.ListQuestionPluginController;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;

public class ExportInterviewUI extends AbstractUI {
    private final QuestionExporterController questionExporterController = new QuestionExporterController();
    private final ListQuestionPluginController listQuestionPluginController = new ListQuestionPluginController(
            PersistenceContext.repositories().questionImporterPlugins(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        Iterable<QuestionImporterPlugin> questionImporterPlugins = listQuestionPluginController
                .filterByType(FileFormat.INTERVIEW.toString());

        final QuestionImporterPlugin questionImporterPlugin = (QuestionImporterPlugin) Utils
                .showAndSelectOne(questionImporterPlugins, "Plugins");

        if (questionImporterPlugin == null) {
            return false;
        }

        try {
            this.questionExporterController.export("jobs4u.core/target/export-questions.", FileFormat.INTERVIEW,
                    questionImporterPlugin.identity().toString());
        } catch (final IntegrityViolationException | IOException | ConcurrencyException e) {
            System.out.println("Something went wrong.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Generate Interview Teamplate";
    }
}
