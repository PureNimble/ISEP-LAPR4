package lapr4.jobs4u.app.backoffice.console.presentation.authz;

import java.util.HashSet;
import java.util.Set;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.candidatemanagement.application.RegisterCandidateController;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.application.AddUserController;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class RegisterCandidateUI extends AbstractUI {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final RegisterCandidateController registerCandidateController = new RegisterCandidateController(
            PersistenceContext.repositories().candidates(txCtx),
            PersistenceContext.repositories().candidateUsers(txCtx), AuthzRegistry.authorizationService());

    private final AddUserController addUserController = new AddUserController();

    @Override
    protected boolean doShow() {

        System.out.println("Candidate Data:");
        final String firstName = Console.readLine("First Name:");
        final String lastName = Console.readLine("Last Name:");
        final String email = Console.readLine("E-mail:");
        final String phoneNumber = Console.readLine("Phone Number:");

        try {
            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.CANDIDATE);
            txCtx.beginTransaction();
            final Candidate customer = this.registerCandidateController.registerCandidate(firstName, lastName, email,
                    phoneNumber);
            final SystemUser user = this.addUserController.addUser(email, firstName,
                    lastName, roleTypes);
            this.registerCandidateController.registerCandidateUser(customer, user);
            txCtx.commit();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            txCtx.rollback();
            System.out.println("That E-mail is already registered.");
        } finally {
            txCtx.close();
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Candidate";
    }
}
