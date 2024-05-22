package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.integration.questions.exporter.application.FileFormat;
import lapr4.jobs4u.integration.questions.importer.application.ListQuestionPluginController;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.jobopeningmanagement.application.EditJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.domain.ModeTypes;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfContract;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.recruitmentprocessmanagement.application.OpenOrClosePhaseController;

public class EditJobOpeningUI extends AbstractUI {

        private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
                        PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

        private final EditJobOpeningController editJobOpeningController = new EditJobOpeningController(
                        PersistenceContext.repositories().jobOpenings(),
                        PersistenceContext.repositories().jobOpeningInterviews(),
                        PersistenceContext.repositories().jobOpeningRequirements(),
                        AuthzRegistry.authorizationService());

        private final OpenOrClosePhaseController openOrClosePhaseController = new OpenOrClosePhaseController(
                        PersistenceContext.repositories().recruitmentProcesses(),
                        PersistenceContext.repositories().jobOpenings(),
                        PersistenceContext.repositories().jobOpeningRequirements(),
                        PersistenceContext.repositories().jobOpeningInterviews(), PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());

        private final ListQuestionPluginController pluginController = new ListQuestionPluginController(
                        PersistenceContext.repositories().questionImporterPlugins(),
                        AuthzRegistry.authorizationService());

        private String titleOrFunction;
        private String contractType;
        private String mode;
        private String address;
        private String jobDescription;
        private String numberOfVacancies;
        private JobOpening theJobOpening;
        private JobOpeningInterview theJobOpeningInterview;
        private JobOpeningRequirement theJobOpeningRequirement;
        private QuestionImporterPlugin interview;
        private QuestionImporterPlugin requirement;
        private Iterable<QuestionImporterPlugin> interviewImporterPlugins;
        private Iterable<QuestionImporterPlugin> requirementImporterPlugins;

        @Override
        protected boolean doShow() {
                final Iterable<JobOpeningDTO> jobOpenings = listJobOpeningsController.filterByCostumerManager();
                final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                                new JobOpeningPrinter());
                String currentPhase;
                JobOpeningDTO theJobOpeningDTO;

                do {
                        selector.show();

                        theJobOpeningDTO = selector.selectedElement();
                        if (theJobOpeningDTO == null) {
                                return false;
                        }

                        theJobOpening = this.listJobOpeningsController.selectedJobOpening(theJobOpeningDTO);
                        System.out.println("\nTitle or Function: " + theJobOpening.titleOrFunction().toString()
                                        + "\nContract Type: " + theJobOpening.contractType().toString()
                                        + "\nMode: " + theJobOpening.mode().toString() + "\nAddress: "
                                        + theJobOpening.address().toString() + "\nJob Description: "
                                        + theJobOpening.jobDescription().toString() + "\nNumber of Vacancies: "
                                        + theJobOpening.numberOfVacancies().toString());

                        Optional<JobOpeningInterview> jobOpeningInterview = this.editJobOpeningController
                                        .interviewModel(theJobOpening);
                        if (jobOpeningInterview.isPresent()) {
                                theJobOpeningInterview = jobOpeningInterview.get();
                                System.out.println("Interview Plugin: "
                                                + theJobOpeningInterview.plugin().identity().toString());
                                interview = theJobOpeningInterview.plugin();

                        }

                        Optional<JobOpeningRequirement> jobOpeningRequirement = this.editJobOpeningController
                                        .requirementModel(theJobOpening);
                        if (jobOpeningRequirement.isPresent()) {
                                theJobOpeningRequirement = jobOpeningRequirement.get();
                                System.out.println("Requirement Plugin: "
                                                + theJobOpeningRequirement.plugin().identity().toString());

                                requirement = theJobOpeningRequirement.plugin();

                        }

                } while (!Utils.confirm("\nDo you wish to edit this Job Opening?"));

                currentPhase = this.openOrClosePhaseController.currentPhase(theJobOpening);
                titleOrFunction = theJobOpening.titleOrFunction().toString();
                contractType = theJobOpening.contractType().toString();
                mode = theJobOpening.mode().toString();
                address = theJobOpening.address().toString();
                jobDescription = theJobOpening.jobDescription().toString();
                numberOfVacancies = theJobOpening.numberOfVacancies().toString();
                boolean changed = false;

                Map<String, Runnable> options = new LinkedHashMap<>();
                List<String> keys = new ArrayList<>();

                if (currentPhase == null) {
                        keys.add("Edit title or function");
                        options.put(keys.get(keys.size() - 1), () -> titleOrFunction = Console
                                        .readNonEmptyLine(
                                                        "Current Title or Function: " + theJobOpening.titleOrFunction()
                                                                        + "\nNew Title or Function:",
                                                        "Title or Function cannot be empty."));
                        keys.add("Edit contract type");
                        options.put(keys.get(keys.size() - 1), () -> contractType = Utils
                                        .showAndSelectOne(Arrays.asList(TypesOfContract.values()),
                                                        "\nCurrent Contract Type: "
                                                                        + theJobOpening.contractType()
                                                                        + "\nSelect a new contract type:")
                                        .toString());
                        keys.add("Edit Mode");
                        options.put(keys.get(keys.size() - 1),
                                        () -> mode = Utils.showAndSelectOne(Arrays.asList(ModeTypes.values()),
                                                        "\nCurrent Mode: " + theJobOpening.mode()
                                                                        + "\nSelect the mode:")
                                                        .toString());
                        keys.add("Edit Address");
                        options.put(keys.get(keys.size() - 1),
                                        () -> address = Console.readNonEmptyLine(
                                                        "Current Address: " + theJobOpening.address()
                                                                        + "\nNew Address:",
                                                        "Address cannot be empty."));
                }
                if (currentPhase == null || currentPhase.equals("ApplicationPhase")) {
                        if (requirement != null) {
                                requirementImporterPlugins = pluginController
                                                .filterByType(FileFormat.REQUIREMENT.toString());
                                keys.add("Edit Requirement Model");
                                options.put(keys.get(keys.size() - 1),
                                                () -> requirement = (QuestionImporterPlugin) Utils
                                                                .showAndSelectOne(requirementImporterPlugins,
                                                                                "\nCurrent Plugin: "
                                                                                                + requirement.identity()
                                                                                                                .toString()
                                                                                                + "\nPlugins:"));
                        } else
                                System.out.println("\nTheres no requirement model to edit.");
                }
                if ((currentPhase == null || currentPhase.equals("ApplicationPhase")
                                || currentPhase.equals("AnalysisPhase"))
                                && theJobOpeningInterview != null) {
                        if (interview != null) {
                                interviewImporterPlugins = pluginController
                                                .filterByType(FileFormat.INTERVIEW.toString());
                                keys.add("Edit Interview Model");
                                options.put(keys.get(keys.size() - 1),
                                                () -> interview = (QuestionImporterPlugin) Utils
                                                                .showAndSelectOne(interviewImporterPlugins,
                                                                                "\nCurrent Plugin: "
                                                                                                + interview.identity()
                                                                                                                .toString()
                                                                                                + "\nPlugins:"));
                        } else
                                System.out.println("\nTheres no interview model to edit.");
                }
                keys.add("Edit Job Description");
                options.put(keys.get(keys.size() - 1), () -> jobDescription = Console
                                .readNonEmptyLine(
                                                "Current Job Description: " + theJobOpening.jobDescription()
                                                                + "\nNew Job Description:",
                                                "Job Description cannot be empty."));
                keys.add("Edit Number of Vacancies");
                options.put(keys.get(keys.size() - 1), () -> numberOfVacancies = Console
                                .readNonEmptyLine("Current Number of Vacancies: " + theJobOpening.numberOfVacancies()
                                                + "\nNew Number of Vacancies:",
                                                "Number of Vacancies cannot be empty."));

                int option = 0;
                do {
                        option = Utils.showAndSelectIndex(keys, "\nJob Opening Fields:");

                        if (option != -1) {
                                options.get(keys.get(option)).run();
                                changed = true;
                        }
                } while (option != -1);

                if (!changed) {
                        System.out.println("\nNo changes were made.");
                        return false;
                }

                System.out.println("\nResult:\nTitle or Function: " + titleOrFunction + "\nContract Type: "
                                + contractType + "\nMode: " + mode + "\nAddress: " + address + "\nJob Description: "
                                + jobDescription + "\nNumber of Vacancies: " + numberOfVacancies);
                
                if (requirement != null)
                        System.out.println("Requirement Plugin: " + requirement.identity().toString());
                if (interview != null)
                        System.out.println("Interview Plugin: " + interview.identity().toString());

                if (!Utils.confirm("\nAre you sure you want to make this changes permanent?")) {
                        System.out.println("\nChanges were not saved.");
                        return false;
                }

                try {
                        this.editJobOpeningController.editJobOpening(titleOrFunction, contractType, mode, address,
                                        jobDescription, numberOfVacancies, theJobOpening);
                        if (theJobOpeningInterview != null)
                                this.editJobOpeningController.editJobOpeningInterview(theJobOpeningInterview,
                                                interview);
                        if (theJobOpeningRequirement != null)
                                this.editJobOpeningController.editJobOpeningRequirement(theJobOpeningRequirement,
                                                requirement);
                        System.out.println("\nJob Opening edited successfully.");
                } catch (final IntegrityViolationException | ConcurrencyException e) {
                        System.out.println("Something went wrong. Please try again.");
                }

                return false;
        }

        @Override
        public String headline() {
                return "Edit Job Opening";
        }

}
