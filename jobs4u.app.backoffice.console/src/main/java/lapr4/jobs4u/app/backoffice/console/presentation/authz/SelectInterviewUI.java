package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.export.application.FileFormat;
import lapr4.jobs4u.integration.questions.import_.application.ListQuestionPluginController;
import lapr4.jobs4u.integration.questions.import_.domain.QuestionImporterPlugin;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.application.SelectInterviewController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class SelectInterviewUI extends AbstractUI {

        private final ListQuestionPluginController interviewController = new ListQuestionPluginController(
                        PersistenceContext.repositories().questionImporterPlugins(),
                        AuthzRegistry.authorizationService());

        private final ListJobOpeningsController jobOpeningController = new ListJobOpeningsController(
                        PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

        private final SelectInterviewController selectInterviewController = new SelectInterviewController(
                        PersistenceContext.repositories().jobOpeningInterviews());

        @Override
        protected boolean doShow() {

                Iterable<JobOpeningDTO> jobs = jobOpeningController
                                .getIntersection(jobOpeningController.filterByCostumerManager());

                final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobs,
                                new JobOpeningPrinter());
                selector.show();
                final JobOpeningDTO jobDto = selector.selectedElement();
                if (jobDto == null) {
                        return false;
                }
                Iterable<QuestionImporterPlugin> questionImporterPlugins = interviewController
                                .filterByType(FileFormat.INTERVIEW.toString());

                final QuestionImporterPlugin questionImporterPlugin = (QuestionImporterPlugin) Utils
                                .showAndSelectOne(questionImporterPlugins, "Plugins");

                if (questionImporterPlugin == null)
                        return false;

                selectInterviewController.addInterviewPluginToJobOpening(JobOpeningInterview
                                .valueOf(jobOpeningController.selectedJobOpening(jobDto), questionImporterPlugin));
                return false;

        }

        @Override
        public String headline() {
                return "Select Interview";
        }
}