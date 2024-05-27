package lapr4.jobs4u.app.backoffice.console;

import lapr4.jobs4u.app.backoffice.console.presentation.FrontMenu;
import lapr4.jobs4u.app.common.console.Jobs4UApplication;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public final class BackOfficeApp extends Jobs4UApplication {

    /**
     * avoid instantiation of this class.
     */
    private BackOfficeApp() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        new BackOfficeApp().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        new FrontMenu().show();
    }

    @Override
    protected String appTitle() {
        return "Jobs4U - BackOffice";
    }

    @Override
    protected String appGoodbye() {
        return "Goodbye!";
    }

    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {}
}
