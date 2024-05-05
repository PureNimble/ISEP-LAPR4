package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.Arrays;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.customermanagement.application.ListCustomersController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.ModeTypes;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfContract;

public class RegisterJobOpeningUI extends AbstractUI {
    private final RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController(
            PersistenceContext.repositories().jobOpenings(), AuthzRegistry.authorizationService());

    private final ListCustomersController listCustomersController = new ListCustomersController(
            PersistenceContext.repositories().customers(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        final String titleOrFunction = Console.readLine("Title or Function:");
        final String contractType = Utils
                .showAndSelectOne(Arrays.asList(TypesOfContract.values()), "\nSelect the contract type:").toString();
        final String mode = Utils.showAndSelectOne(Arrays.asList(ModeTypes.values()), "\nSelect the mode:").toString();
        final String address = Console.readLine("\nAddress:");
        final String jobDescription = Console.readLine("\nJob Description:");
        final String numberOfVacancies = Console.readLine("\nNumber of vacancies:");

        try {
            Iterable<Customer> customerList = this.listCustomersController.filterByCostumerManager();
            Customer customer = (Customer) Utils.showAndSelectOne(customerList, "\nSelect the customer:");
            this.registerJobOpeningController.SetUpJobOpening(titleOrFunction, contractType, mode,
                    address, customer, jobDescription, numberOfVacancies);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("There is already a job opening with that job reference. Please try again.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Job Opening Process";
    }
}
