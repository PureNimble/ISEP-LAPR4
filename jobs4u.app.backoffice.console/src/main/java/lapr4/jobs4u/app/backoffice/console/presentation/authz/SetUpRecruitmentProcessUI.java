package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.recruitmentprocessmanagement.application.SetUpRecruitmentProcessController;

public class SetUpRecruitmentProcessUI extends AbstractUI  {
    private final SetUpRecruitmentProcessController registerCustomerController = new SetUpRecruitmentProcessController(
            PersistenceContext.repositories().recruitmentProcesses());

    @Override
    protected boolean doShow() {

        System.out.println("Application Phase:");
        final String applicationInitialDate = Console.readLine("Initial Date:");
        final String applicationFinalDate = Console.readLine("Final Date:");

        System.out.println("Screening Phase:");
        final String screeningInitialDate = Console.readLine("Initial Date:");
        final String screeningFinalDate = Console.readLine("Final Date:");

        System.out.println("Interview Phase:");
        final String interviewInitialDate = Console.readLine("Initial Date:");
        final String interviewFinalDate = Console.readLine("Final Date:");

        System.out.println("Analysis Phase:");
        final String analysisInitialDate = Console.readLine("Initial Date:");
        final String analysisFinalDate = Console.readLine("Final Date:");

        System.out.println("Result Phase:");
        final String resultInitialDate = Console.readLine("Initial Date:");
        final String resultFinalDate = Console.readLine("Final Date:");

        try {
            this.registerCustomerController.SetUpRecruitmentProcess(applicationInitialDate, applicationFinalDate,
                    screeningInitialDate, screeningFinalDate, interviewInitialDate, interviewFinalDate,
                    analysisInitialDate, analysisFinalDate, resultInitialDate, resultFinalDate);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That E-mail is already registered.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "SetUP Recruitment Process";
    }
}
