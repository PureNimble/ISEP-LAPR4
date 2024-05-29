package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.requirementmanagement.application.EvaluateRequirementsController;

/**
 * @author 2DI2
 */
public class EvaluateRequirementUI extends AbstractUI {

    private final EvaluateRequirementsController evaluateRequirementController = new EvaluateRequirementsController(
            PersistenceContext.repositories().requirementsQuestion(),
            PersistenceContext.repositories().recruitmentProcesses(),
            PersistenceContext.repositories().jobOpeningRequirements(),
            PersistenceContext.repositories().requirements(),
            AuthzRegistry.authorizationService());
    private final ListJobOpeningsController listJobpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpenings = this.listJobpeningsController
                .filterWithAvailablePhaseForRequirementsEvaluation();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }

        final JobOpening theJobOpening = listJobpeningsController.selectedJobOpening(theJobOpeningDTO);

        try {
            this.evaluateRequirementController.evaluateRequirement(theJobOpening);
        } catch (final Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Evaluate Requirement";
    }
}