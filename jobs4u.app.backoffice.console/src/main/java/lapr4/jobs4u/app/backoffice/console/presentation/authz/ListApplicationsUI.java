package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.Collections;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.ApplicationPrinter;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationsController;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

/**
 * @author 2DI2
 */
public class ListApplicationsUI extends AbstractListUI<ApplicationDTO> {

    private final ListApplicationsController listApplicationsController = new ListApplicationsController(
            PersistenceContext.repositories().applications(), AuthzRegistry.authorizationService());
    private final ListJobOpeningsController listJobpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @Override
    public String headline() {
        return "List Applications";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<ApplicationDTO> elements() {
        final Iterable<JobOpeningDTO> jobOpenings = this.listJobpeningsController.filterByCostumerManager();
        final SelectWidget<JobOpeningDTO> selector = new SelectWidget<>("Job Openings:", jobOpenings,
                new JobOpeningPrinter());
        selector.show();
        final JobOpeningDTO theJobOpeningDTO = selector.selectedElement();
        if (theJobOpeningDTO == null) {
            return Collections.emptyList();
        }
        JobOpening theJobOpening = listJobpeningsController.selectedJobOpening(theJobOpeningDTO);
        return applicationsByJobOpening(theJobOpening);
    }

    protected Iterable<ApplicationDTO> applicationsByJobOpening(final JobOpening jobOpening) {
        return listApplicationsController.filterByJobOpening(jobOpening);
    }

    @Override
    protected Visitor<ApplicationDTO> elementPrinter() {
        return new ApplicationPrinter();
    }

    @Override
    protected String elementName() {
        return "Applications";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-15s%-40s", "APP. CODE", "CANDIDATE INFO");
    }
}