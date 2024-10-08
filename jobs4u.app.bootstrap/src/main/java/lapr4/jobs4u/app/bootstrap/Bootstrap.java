package lapr4.jobs4u.app.bootstrap;

import lapr4.jobs4u.app.common.console.Jobs4UApplication;
import lapr4.jobs4u.infrastructure.bootstrapers.Bootstrapper;
import lapr4.jobs4u.infrastructure.bootstrapers.demo.DemoBootstrapper;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.infrastructure.smoketests.Jobs4UDemoSmokeTester;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.collections.util.ArrayPredicates;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import eapli.framework.io.util.Console;

/**
 * Base Bootstrapping data app
 */
/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public final class Bootstrap extends Jobs4UApplication {
    /**
     * avoid instantiation of this class.
     */
    private Bootstrap() {
    }

    private boolean isToBootstrapDemoData;
    private boolean isToRunSampleE2E;
    private boolean isToWaitInTheEnd;

    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());

        new Bootstrap().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        handleArgs(args);

        System.out.println("\n\n------- MASTER DATA -------");
        new Bootstrapper().execute();

        if (isToBootstrapDemoData) {
            System.out.println("\n\n------- DEMO DATA -------");
            new DemoBootstrapper().execute();
        }
        if (isToRunSampleE2E) {
            System.out.println("\n\n------- BASIC SCENARIO -------");
            new Jobs4UDemoSmokeTester().execute();
        }
        if (isToWaitInTheEnd) {
            Console.readLine("\n\n>>>>>> Enter to finish the program.");
        }
    }

    private void handleArgs(final String[] args) {
        isToWaitInTheEnd = ArrayPredicates.contains(args, "-wait");
        isToRunSampleE2E = ArrayPredicates.contains(args, "-smoke:basic");
        if (isToRunSampleE2E) {
            isToBootstrapDemoData = true;
        } else {
            isToBootstrapDemoData = ArrayPredicates.contains(args, "-bootstrap:demo");
        }
    }

    @Override
    protected String appTitle() {
        return "Bootstrapping Jobs4U data ";
    }

    @Override
    protected String appGoodbye() {
        return "Bootstrap data done.";
    }

    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {}
}
