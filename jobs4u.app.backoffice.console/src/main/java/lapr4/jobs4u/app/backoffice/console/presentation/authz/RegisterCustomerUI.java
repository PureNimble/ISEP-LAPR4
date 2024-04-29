package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.HashSet;
import java.util.Set;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.customerusermanagement.application.RegisterCustomerController;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController registerCustomerController = new RegisterCustomerController(
            PersistenceContext.repositories().customers());

    private final AddUserController addUserController = new AddUserController();

    @Override
    protected boolean doShow() {
        System.out.println("Company Data:");
        final String companyName = Console.readLine("Name:");
        final String companyAddress = Console.readLine("Address:");
        final String companyCode = Console.readLine("Code:");
        final String companyEmail = Console.readLine("E-mail:");
        final String companyPhoneNumber = Console.readLine("Phone Number:");

        System.out.println("Representative Data:");
        final String representativefirstName = Console.readLine("First Name:");
        final String representativelastName = Console.readLine("Last Name:");
        final String representativeEmail = Console.readLine("E-mail:");
        final String representativephoneNumber = Console.readLine("Phone Number:");

        try {
            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.CUSTOMER);
            this.registerCustomerController.registerCustomer(
                    (this.addUserController.addUser(representativeEmail, representativefirstName,
                            representativelastName, roleTypes)),
                    companyName, companyAddress, companyCode, companyEmail, companyPhoneNumber);
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
