package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.PrintStream;

import org.hibernate.event.spi.PersistContext;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

public class ListJobOpeningsUI extends AbstractListUI<JobOpeningDTO> {

    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected boolean doShow() {

        Iterable<JobOpeningDTO> elems = this.elements();
        if (!elems.iterator().hasNext()) {
            PrintStream var10000 = System.out;
            String var10001 = this.emptyMessage();
            var10000.println(var10001 + this.elementName());
        } else {
            (new ListWidget(this.listHeader(), elems, this.elementPrinter())).show();
        }

        // TODO: implement filters

        return true;
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<JobOpeningDTO> elements() {
        return listJobOpeningsController.filterByCostumerManager();
    }

    @Override
    protected Visitor<JobOpeningDTO> elementPrinter() {
        return new JobOpeningPrinter();
    }

    @Override
    protected String elementName() {
        return "Job Opening";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-15s%-20s%-15s", "C. CODE", "C. NAME", "J. REFERENCE");
    }
}