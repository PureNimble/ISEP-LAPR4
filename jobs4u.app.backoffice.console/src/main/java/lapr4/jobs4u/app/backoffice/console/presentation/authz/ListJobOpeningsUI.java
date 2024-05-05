package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.visitor.Visitor;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.printer.JobOpeningPrinter;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.customermanagement.application.ListCustomersController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningsController;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;

public class ListJobOpeningsUI extends AbstractListUI<JobOpeningDTO> {

    private final ListJobOpeningsController listJobOpeningsController = new ListJobOpeningsController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());
    private final ListCustomersController listCustomersController = new ListCustomersController(
            PersistenceContext.repositories().customers(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> elems = this.elements();

        if (showList(elems)) {

            while (Utils.confirm("\nApply Filters?")) {
                final List<String> options = Arrays.asList("Filter by Customer", "Filter by Active", "Filter by Date",
                        "Show Full List");
                final int option = Utils.showAndSelectIndex(options, "\nWhich filter do you wish to apply?");

                switch (option) {
                    case 0:
                        Customer customer = (Customer) Utils.showAndSelectOne(
                                this.listCustomersController.filterByCostumerManager(),
                                "Select the customer:");
                        elems = this.jobOpeningsByCustomer(customer);
                        break;
                    case 1:
                        final List<String> activeOptions = Arrays.asList("See Active Job Openings",
                                "See Inactive Job Openings");
                        final int activeOption = Utils.showAndSelectIndex(activeOptions,
                                "\nWhich type of Job Opening do you want to see?");
                        elems = this.jobOpeningsByActive(activeOption == 0);
                        break;
                    case 2:
                        final Calendar initialDate = Utils.readDateFromConsole("Enter a initial date (MM-yyyy): ",
                                "MM-yyyy",
                                "^(0[1-9]|1[012])-((19|20)\\d\\d)$");

                        Calendar finalDate;
                        do {
                            finalDate = Utils.readDateFromConsole("Enter a final date (MM-yyyy): ",
                                    "MM-yyyy",
                                    "^(0[1-9]|1[012])-((19|20)\\d\\d)$");
                            if (finalDate.before(initialDate) || finalDate.equals(initialDate)) {
                                System.out.println("Final date must be after the initial date. Please enter again.");
                            }
                        } while (finalDate.before(initialDate) || finalDate.equals(initialDate));
                        elems = this.jobOpeningsByDate(initialDate, finalDate);
                        break;
                    case 3:
                        elems = this.elements();
                        break;
                    default:
                        System.out.println("Invalid filter option.");
                        return true;
                }
                showList(elems);
            }
        }

        return true;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected boolean showList(final Iterable<JobOpeningDTO> elems) {
        if (!elems.iterator().hasNext()) {
            PrintStream var10000 = System.out;
            String var10001 = this.emptyMessage();
            var10000.println(var10001);
            return false;
        } else {
            (new ListWidget(this.listHeader(), elems, this.elementPrinter())).show();
        }
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

    protected Iterable<JobOpeningDTO> jobOpeningsByCustomer(final Customer customer) {
        return listJobOpeningsController.filterByCustomer(customer);
    }

    protected Iterable<JobOpeningDTO> jobOpeningsByActive(final boolean active) {
        return listJobOpeningsController.getIntersection(listJobOpeningsController.filterByActive(active));
    }

    protected Iterable<JobOpeningDTO> jobOpeningsByDate(final Calendar initialDate, final Calendar finalDate) {
        return listJobOpeningsController
                .getIntersection(listJobOpeningsController.filterByPeriod(initialDate, finalDate));
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
        return String.format("#  %-15s%-20s%-15s%-30s", "C. CODE", "C. NAME", "J. REFERENCE", "J. TITLE");
    }
}