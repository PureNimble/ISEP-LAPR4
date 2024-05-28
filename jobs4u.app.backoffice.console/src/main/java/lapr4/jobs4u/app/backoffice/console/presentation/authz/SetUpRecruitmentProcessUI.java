package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.recruitmentprocessmanagement.application.SetUpRecruitmentProcessController;

/**
 * @author 2DI2
 */
public class SetUpRecruitmentProcessUI extends AbstractUI {
    private final SetUpRecruitmentProcessController registerCustomerController = new SetUpRecruitmentProcessController(
            PersistenceContext.repositories().recruitmentProcesses(), PersistenceContext.repositories().jobOpenings(),
            AuthzRegistry.authorizationService());

    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        Iterable<JobOpeningDTO> jobOpeningList = this.listJobOpeningsController
                .getIntersection(listJobOpeningsController.hasRecruitmentProcess(false));
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpeningList,
                new JobOpeningPrinter());
        selector.show();
        JobOpeningDTO jobOpeningDTO = selector.selectedElement();

        if (jobOpeningDTO == null) {
            return false;
        }

        JobOpening jobOpening = this.listJobOpeningsController.selectedJobOpening(jobOpeningDTO);

        System.out.println("\nApplication Phase:");
        final String applicationInitialDate = Console.readLine("Initial Date:");
        final String applicationFinalDate = Console.readLine("Final Date:");

        System.out.println("\nScreening Phase:");
        final String screeningInitialDate = Console.readLine("Initial Date:");
        final String screeningFinalDate = Console.readLine("Final Date:");

        final boolean interviewPhase = Utils.confirm("\nDo you wish to register an Interview Phase?");

        String interviewInitialDate = "";
        String interviewFinalDate = "";

        if (interviewPhase) {
            System.out.println("Interview Phase:");
            interviewInitialDate = Console.readLine("Initial Date:");
            interviewFinalDate = Console.readLine("Final Date:");
        }

        System.out.println("\nAnalysis Phase:");
        final String analysisInitialDate = Console.readLine("Initial Date:");
        final String analysisFinalDate = Console.readLine("Final Date:");

        System.out.println("\nResult Phase:");
        final String resultInitialDate = Console.readLine("Initial Date:");
        final String resultFinalDate = Console.readLine("Final Date:");

        try {
            if (interviewPhase) {
                this.registerCustomerController.SetUpRecruitmentProcess(applicationInitialDate, applicationFinalDate,
                        screeningInitialDate, screeningFinalDate, interviewInitialDate, interviewFinalDate,
                        analysisInitialDate, analysisFinalDate, resultInitialDate, resultFinalDate, jobOpening);
            } else {
                this.registerCustomerController.SetUpRecruitmentProcess(applicationInitialDate, applicationFinalDate,
                        screeningInitialDate, screeningFinalDate,
                        analysisInitialDate, analysisFinalDate, resultInitialDate, resultFinalDate, jobOpening);
            }

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That Job Reference is already registered.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "SetUP Recruitment Process";
    }
}
