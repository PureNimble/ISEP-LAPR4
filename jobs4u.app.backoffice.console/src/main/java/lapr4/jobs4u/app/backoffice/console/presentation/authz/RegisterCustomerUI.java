package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.HashSet;
import java.util.Set;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.customermanagement.application.RegisterCustomerController;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController registerCustomerController = new RegisterCustomerController(
            PersistenceContext.repositories().customers(), PersistenceContext.repositories().customerUsers());

    private final AddUserController addUserController = new AddUserController();

    @Override
    protected boolean doShow() {
        System.out.println("\nCompany Data:\n");
        final String companyName = Console.readLine("Name:");
        final String companyAddress = Console.readLine("Address:");
        final String companyCode = Console.readLine("Code:");
        final String companyEmail = Console.readLine("E-mail:");
        final String companyPhoneNumber = Console.readLine("Phone Number:");

        System.out.println("\nRepresentative Data:\n");
        final String representativefirstName = Console.readLine("First Name:");
        final String representativelastName = Console.readLine("Last Name:");
        final String representativeEmail = Console.readLine("E-mail:");

        try {
            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.CUSTOMER);
            final Customer customer = this.registerCustomerController.registerCustomer(companyName, companyAddress, companyCode, companyEmail, companyPhoneNumber);
            final SystemUser user = this.addUserController.addUser(representativeEmail, representativefirstName, representativelastName, roleTypes);
            this.registerCustomerController.registerCustomerUser(customer, user);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That E-mail is already registered.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Customer";
    }
}
