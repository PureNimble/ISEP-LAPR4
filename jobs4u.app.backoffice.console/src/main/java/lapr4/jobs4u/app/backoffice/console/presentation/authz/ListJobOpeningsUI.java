package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.customermanagement.application.ListCustomersController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

public class ListJobOpeningsUI extends AbstractListUI<JobOpeningDTO> {

    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListCustomersController listCustomersController = new ListCustomersController();

    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> elems = this.elements();
        showList(elems);
    
        while (Utils.confirm("\nDo you want to filter the list?")) {
            final List<String> options = Arrays.asList("Filter by Customer", "Filter by Active", "Filter by Date");
            final int option = Utils.showAndSelectIndex(options, "\nWhich filter do you wish to apply?");
    
            switch (option) {
                case 0:
                    Customer customer = (Customer) Utils.showAndSelectOne(
                            this.listCustomersController.filterByCostumerManager(), 
                            "Select the customer:"
                    );
                    elems = this.jobOpeningsByCustomer(customer);
                    break;
                case 1:
                    final List<String> activeOptions = Arrays.asList("See Active Job Openings", "See Inactive Job Openings");
                    final int activeOption = Utils.showAndSelectIndex(activeOptions, "\nWhich type of Job Opening do you want to see?");
                    elems = this.jobOpeningsByActive(activeOption==0);
                    break;
                case 2:
                    final Calendar day = Console.readCalendar("\nInsert the date (dd-mm-yyyy):", "dd-MM-yyyy");
                    elems = this.jobOpeningsByDate(day);
                    break;
                default:
                    System.out.println("Invalid filter option.");
                    return true;
            }
    
        }
    
        return true;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void showList(final Iterable<JobOpeningDTO> elems) {
        if (!elems.iterator().hasNext()) {
            PrintStream var10000 = System.out;
            String var10001 = this.emptyMessage();
            var10000.println(var10001 + this.elementName());
        } else {
            (new ListWidget(this.listHeader(), elems, this.elementPrinter())).show();
        }
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

    protected Iterable<JobOpeningDTO> jobOpeningsByCustomer(final Customer customer) {
        return listJobOpeningsController.filterByCustomer(customer);
    }

    protected Iterable<JobOpeningDTO> jobOpeningsByActive(final boolean active) {
        return listJobOpeningsController.filterByActive(active);
    }

    protected Iterable<JobOpeningDTO> jobOpeningsByDate(final Calendar date) {
        return listJobOpeningsController.filterByDate(date);
    }

    @Override
    protected Visitor<JobOpeningDTO> elementPrinter() {
        return new JobOpeningPrinter();
    }

    @Override
    protected String elementName() {
        return "Job Openings";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-15s%-20s%-15s", "C. CODE", "C. NAME", "J. REFERENCE");
    }
}