package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.customermanagement.application.ListCustomersController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.ModeTypes;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfContract;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.rankmanagement.application.RegisterRankController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 2DI2
 */
public class RegisterRankUI extends AbstractUI {

    private final int MAGNITUDE = 1;

    private final ListJobOpeningsController jobOpeningsController = new ListJobOpeningsController(PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListApplicationsController applicationsController = new ListApplicationsController(PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());


    private final RegisterRankController controller = new RegisterRankController(
           AuthzRegistry.authorizationService(), PersistenceContext.repositories().ranks());


    @Override
    protected boolean doShow() {
        final Iterable<JobOpeningDTO> jobOpenings = this.jobOpeningsController.filterWithAvailablePhaseForInterviews();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }
        JobOpening theJobOpening = jobOpeningsController.selectedJobOpening(theJobOpeningDTO);

        int numCandidatesNeeded = Integer.parseInt(theJobOpeningDTO.getNumberOfVacancies());

        Iterable<ApplicationDTO> applicationDTOS = applicationsController.filterByJobOpening(theJobOpening);

        List<Application> applications = new ArrayList<>();

        for (ApplicationDTO applicationDTO : applicationDTOS) {
            applications.add(applicationsController.selectedApplication(applicationDTO));
        }

        for (int i = 0; i < numCandidatesNeeded + numCandidatesNeeded * MAGNITUDE; i++){
            System.out.printf("Rank nº %d\n", i + 1);
            final String email = Console.readLine("Candidate email:");
            for(Application application : applications){
                if(application.candidate().emailAddress().matches(email)){
                    try {
                        this.controller.setupRank(String.valueOf(i+1), application, theJobOpening);
                    } catch (final IntegrityViolationException | ConcurrencyException e) {
                        System.out.println("There is already a rank with that rank reference. Please try again.");
                    }
                    applications.remove(application);
                    break;
                }
            }
        }
        for(Application application : applications){
            try {
                this.controller.setupRank("Rank not recorded", application, theJobOpening);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("There is already a rank with that rank reference. Please try again.");
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Rank Candidates";
    }
}
