package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import lapr4.jobs4u.infrastructure.bootstrapers.Bootstrapper;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.strings.util.Strings;
import eapli.framework.validations.Invariants;

/**
 * Base Bootstrapping data app
 *
 * @todo avoid duplication with {@link Bootstrapper}
 *
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public class DemoBootstrapper implements Action {

    private static final String POWERUSER_A1 = "poweruserA1";
    private static final String POWERUSER = "poweruser@email.local";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();

    @Override
    public boolean execute() {
        // declare bootstrap actions
        final Action[] actions = { new BackofficeUsersBootstrapper(), new CustomerBootstrapper(),
                new CandidateBootstrapper(), new QuestionTypeBootstrapper()
        };

        authenticateForBootstrapping();

        // execute all bootstrapping
        boolean ret = true;
        for (final Action boot : actions) {
            System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
            ret &= boot.execute();
        }
        return ret;
    }

    /**
     * authenticate a super user to be able to register new users
     *
     */
    protected void authenticateForBootstrapping() {
        authenticationService.authenticate(POWERUSER, POWERUSER_A1);
        Invariants.ensure(authz.hasSession());
    }

    private String nameOfEntity(final Action boot) {
        final String name = boot.getClass().getSimpleName();
        return Strings.left(name, name.length() - "Bootstrapper".length());
    }
}
