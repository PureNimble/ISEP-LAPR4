package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.applicationmanagement.application.PublishResultsController;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class PublishResultsUI extends AbstractUI {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final PublishResultsController publishResultsController = new PublishResultsController(
            PersistenceContext.repositories().applications(txCtx), PersistenceContext.repositories().ranks(),
            PersistenceContext.repositories().interviews(),
            PersistenceContext.repositories().requirements(),
            PersistenceContext.repositories().newTransactionalContext(),
            AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final Iterable<JobOpeningDTO> jobOpeningsList = listJobOpeningsController.filterWithAvailableForResults();

        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpeningsList,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO jobOpeningDto = selector.selectedElement();
        if (jobOpeningDto == null) {
            return false;
        }

        final JobOpening selectedJobOpening = listJobOpeningsController.selectedJobOpening(jobOpeningDto);

        try {
            publishResultsController.publishResults(selectedJobOpening);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            txCtx.rollback();
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Publish Results";
    }
}
