package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.Arrays;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.common.console.presentation.utils.Utils;
import lapr4.jobs4u.customermanagement.application.ListCustomersController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.ModeTypes;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfContract;

public class RegisterJobOpeningUI extends AbstractUI  {
    private final RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController(
            PersistenceContext.repositories().jobOpenings());

    private final ListCustomersController listCustomersController = new ListCustomersController();

    @Override
    protected boolean doShow() {

        final String titleOrFunction = Console.readLine("Title or Function:");
        final String contractType = Utils.showAndSelectOne(Arrays.asList(TypesOfContract.values()), "Select the contract type:").toString();
        final String mode = Utils.showAndSelectOne(Arrays.asList(ModeTypes.values()), "Select the mode:").toString();
        final String address = Console.readLine("Address:");
        final String jobDescription = Console.readLine("Job Description:");

        try {
            //TODO: job reference should be generated automatically by the system
            String jobReference = "2";
            Iterable<Customer> customerList = this.listCustomersController.filterByCostumerManager();
            Customer customer = (Customer) Utils.showAndSelectOne(customerList, "Select the customer:");
            this.registerJobOpeningController.SetUpJobOpening(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription);
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

