package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import eapli.framework.domain.repositories.TransactionalContext;
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

/**
 * @author 2DI2
 */
public class EditJobOpeningUI extends AbstractUI {

    private final TransactionalContext ctx = PersistenceContext.repositories().newTransactionalContext();
    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    private final EditJobOpeningController editJobOpeningController = new EditJobOpeningController(
            PersistenceContext.repositories().jobOpenings(ctx),
            PersistenceContext.repositories().jobOpeningInterviews(ctx),
            PersistenceContext.repositories().jobOpeningRequirements(ctx),
            PersistenceContext.repositories().recruitmentProcesses(),
            AuthzRegistry.authorizationService());

    private final ListQuestionPluginController pluginController = new ListQuestionPluginController(
            PersistenceContext.repositories().questionImporterPlugins(),
            AuthzRegistry.authorizationService());

    private JobOpening selectedJobOpening;
    private JobOpeningInterview selectedJobOpeningInterview;
    private JobOpeningRequirement selectedJobOpeningRequirement;
    private QuestionImporterPlugin selectedInterviewPlugin;
    private QuestionImporterPlugin selectedRequirementPlugin;
    private Iterable<QuestionImporterPlugin> interviewImporterPlugins;
    private Iterable<QuestionImporterPlugin> requirementImporterPlugins;

    private String titleOrFunction;
    private String contractType;
    private String mode;
    private String address;
    private String jobDescription;
    private String numberOfVacancies;

    @Override
    protected boolean doShow() {
        final Iterable<JobOpeningDTO> jobOpenings = listJobOpeningsController.filterByCostumerManager();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        String currentPhase = null;
        do {
            selector.show();
            final JobOpeningDTO selectedJobOpeningDTO = selector.selectedElement();
            if (selectedJobOpeningDTO == null) {
                return false;
            }

            selectedJobOpening = listJobOpeningsController.selectedJobOpening(selectedJobOpeningDTO);
            displayJobOpeningDetails(selectedJobOpening);
            editJobOpeningController.currentPhase(selectedJobOpening);

            if (currentPhase != null && currentPhase.equals("ResultPhase")) {
                System.out.println("\nThis Job Opening is in the Result Phase and cannot be edited.");
                return false;
            }
        } while (!Utils.confirm("\nDo you wish to edit this Job Opening?"));

        loadJobOpeningFields();
        if (!updateFields(currentPhase)) {
            System.out.println("\nNo changes were made.");
            return false;
        }

        if (!confirmAndSaveChanges()) {
            System.out.println("\nChanges were not saved.");
            return false;
        }

        System.out.println("\nJob Opening edited successfully.");
        return false;
    }

    private void displayJobOpeningDetails(final JobOpening jobOpening) {
        System.out.println("\nTitle or Function: " + jobOpening.titleOrFunction()
                + "\nContract Type: " + jobOpening.contractType()
                + "\nMode: " + jobOpening.mode()
                + "\nAddress: " + jobOpening.address()
                + "\nJob Description: " + jobOpening.jobDescription()
                + "\nNumber of Vacancies: " + jobOpening.numberOfVacancies());

        final Optional<JobOpeningInterview> jobOpeningInterview = editJobOpeningController.interviewModel(jobOpening);
        jobOpeningInterview.ifPresent(interview -> {
            selectedJobOpeningInterview = interview;
            selectedInterviewPlugin = interview.plugin();
            System.out.println("Interview Plugin: " + selectedInterviewPlugin.identity());
        });

        final Optional<JobOpeningRequirement> jobOpeningRequirement = editJobOpeningController
                .requirementModel(jobOpening);
        jobOpeningRequirement.ifPresent(requirement -> {
            selectedJobOpeningRequirement = requirement;
            selectedRequirementPlugin = requirement.plugin();
            System.out.println("Requirement Plugin: " + selectedRequirementPlugin.identity());
        });
    }

    private void loadJobOpeningFields() {
        titleOrFunction = selectedJobOpening.titleOrFunction().toString();
        contractType = selectedJobOpening.contractType().toString();
        mode = selectedJobOpening.mode().toString();
        address = selectedJobOpening.address().toString();
        jobDescription = selectedJobOpening.jobDescription().toString();
        numberOfVacancies = selectedJobOpening.numberOfVacancies().toString();
    }

    private boolean updateFields(final String currentPhase) {
        final Map<String, Runnable> options = new LinkedHashMap<>();
        final List<String> keys = new ArrayList<>();

        addGeneralEditOptions(options, keys);
        addPhaseSpecificOptions(options, keys, currentPhase);

        boolean changed = false;
        int option;
        do {
            option = Utils.showAndSelectIndex(keys, "\nJob Opening Fields:");
            if (option != -1) {
                options.get(keys.get(option)).run();
                changed = true;
            }
        } while (option != -1);
        return changed;
    }

    private void addGeneralEditOptions(final Map<String, Runnable> options, final List<String> keys) {
        keys.add("Edit title or function");
        options.put(keys.get(keys.size() - 1), () -> titleOrFunction = Console.readNonEmptyLine(
                "Current Title or Function: " + selectedJobOpening.titleOrFunction()
                        + "\nNew Title or Function:",
                "Title or Function cannot be empty."));

        keys.add("Edit Job Description");
        options.put(keys.get(keys.size() - 1), () -> jobDescription = Console.readNonEmptyLine(
                "Current Job Description: " + selectedJobOpening.jobDescription()
                        + "\nNew Job Description:",
                "Job Description cannot be empty."));

        keys.add("Edit contract type");
        options.put(keys.get(keys.size() - 1), () -> contractType = Utils.showAndSelectOne(
                Arrays.asList(TypesOfContract.values()),
                "\nCurrent Contract Type: " + selectedJobOpening.contractType()
                        + "\nSelect a new contract type:")
                .toString());

        keys.add("Edit Mode");
        options.put(keys.get(keys.size() - 1), () -> mode = Utils.showAndSelectOne(Arrays.asList(ModeTypes.values()),
                "\nCurrent Mode: " + selectedJobOpening.mode() + "\nSelect the mode:").toString());

        keys.add("Edit Address");
        options.put(keys.get(keys.size() - 1),
                () -> address = Console.readNonEmptyLine(
                        "Current Address: " + selectedJobOpening.address() + "\nNew Address:",
                        "Address cannot be empty."));

        keys.add("Edit Number of Vacancies");
        options.put(keys.get(keys.size() - 1),
                () -> numberOfVacancies = Console.readNonEmptyLine("Current Number of Vacancies: "
                        + selectedJobOpening.numberOfVacancies() + "\nNew Number of Vacancies:",
                        "Number of Vacancies cannot be empty."));
    }

    private void addPhaseSpecificOptions(final Map<String, Runnable> options, final List<String> keys,
            final String currentPhase) {
        if (currentPhase == null || currentPhase.equals("ApplicationPhase")) {
            if (selectedRequirementPlugin != null) {
                requirementImporterPlugins = pluginController.filterByType(FileFormat.REQUIREMENT.toString());
                keys.add("Edit Requirement Model");
                options.put(keys.get(keys.size() - 1),
                        () -> selectedRequirementPlugin = (QuestionImporterPlugin) Utils.showAndSelectOne(
                                requirementImporterPlugins,
                                "\nCurrent Plugin: " + selectedRequirementPlugin.identity() + "\nPlugins:"));
            } else {
                System.out.println("\nThere's no requirement model to edit.");
            }
        }

        if (currentPhase == null || currentPhase.equals("ApplicationPhase") || currentPhase.equals("ScreeningPhase")) {
            if (selectedInterviewPlugin != null) {
                interviewImporterPlugins = pluginController.filterByType(FileFormat.INTERVIEW.toString());
                keys.add("Edit Interview Model");
                options.put(keys.get(keys.size() - 1),
                        () -> selectedInterviewPlugin = (QuestionImporterPlugin) Utils.showAndSelectOne(
                                interviewImporterPlugins,
                                "\nCurrent Plugin: " + selectedInterviewPlugin.identity() + "\nPlugins:"));
            } else {
                System.out.println("\nThere's no interview model to edit.");
            }
        }
    }

    private boolean confirmAndSaveChanges() {
        System.out.println("\nResult:\nTitle or Function: " + titleOrFunction
                + "\nContract Type: " + contractType
                + "\nMode: " + mode
                + "\nAddress: " + address
                + "\nJob Description: " + jobDescription
                + "\nNumber of Vacancies: " + numberOfVacancies);

        if (selectedRequirementPlugin != null)
            System.out.println("Requirement Plugin: " + selectedRequirementPlugin.identity());
        if (selectedInterviewPlugin != null)
            System.out.println("Interview Plugin: " + selectedInterviewPlugin.identity());

        if (!Utils.confirm("\nAre you sure you want to make these changes permanent?")) {
            return false;
        }

        try {
            ctx.beginTransaction();
            editJobOpeningController.editJobOpening(titleOrFunction, contractType, mode, address, jobDescription,
                    numberOfVacancies, selectedJobOpening);
            if (selectedJobOpeningInterview != null)
                editJobOpeningController.editJobOpeningInterview(selectedJobOpeningInterview, selectedInterviewPlugin);
            if (selectedJobOpeningRequirement != null)
                editJobOpeningController.editJobOpeningRequirement(selectedJobOpeningRequirement,
                        selectedRequirementPlugin);
            ctx.commit();
        } catch (final Exception e) {
            ctx.rollback();
            System.out.println("Something went wrong. Please try again.");
            return false;
        } finally {
            ctx.close();
        }
        return true;
    }

    @Override
    public String headline() {
        return "Edit Job Opening";
    }
}
