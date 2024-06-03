package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.rankmanagement.application.RegisterRankController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 2DI2
 */
public class RegisterRankUI extends AbstractUI {

    private final ListJobOpeningsController jobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListApplicationsController applicationsController = new ListApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());

    private final RegisterRankController controller = new RegisterRankController(
            AuthzRegistry.authorizationService(), PersistenceContext.repositories().ranks());

    @Override
    protected boolean doShow() {
        final Iterable<JobOpeningDTO> jobOpenings = this.jobOpeningsController.filterWithAvailablePhaseForRanking();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return false;
        }
        final JobOpening theJobOpening = jobOpeningsController.selectedJobOpening(theJobOpeningDTO);

        final List<ApplicationDTO> applicationDTOS = (List<ApplicationDTO>) applicationsController
                .filterByJobOpening(theJobOpening);
        List<Application> applications = new LinkedList<>();
        int i;
        for (i = 0; i < applicationDTOS.size(); i++) {
            System.out.printf("Rank nº %d\n", i + 1);
            final SelectWidget<ApplicationDTO> applicationSelector = new SelectWidget<>("Candidates: ",
                    applicationDTOS,
                    new ApplicationPrinter());
            applicationSelector.show();
            final ApplicationDTO applicationDTO = applicationSelector.selectedElement();
            if (applicationDTO == null) {
                return false;
            }
            applicationDTOS.remove(applicationDTO);
            final Application application = applicationsController.selectedApplication(applicationDTO);
            applications.add(application);

        }
        for (final Application application : applications) {
            try {
                final Integer index = applications.indexOf(application) + 1;
                this.controller.setupRank(Integer.toString(index), application);
                applications.remove(application);
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
