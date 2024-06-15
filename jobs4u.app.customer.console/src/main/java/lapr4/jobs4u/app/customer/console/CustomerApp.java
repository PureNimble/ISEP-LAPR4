package lapr4.jobs4u.app.customer.console;

import lapr4.jobs4u.AppSettings;
import lapr4.jobs4u.app.common.ClientBackend;
import lapr4.jobs4u.app.common.DisconnectAction;
import lapr4.jobs4u.app.customer.console.presentation.FrontMenu;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;

import java.io.IOException;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

/**
 * @author 2DI2
 */
@SuppressWarnings("squid:S106")
public final class CustomerApp {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private CustomerApp() {
    }

    public static void main(final String[] args) {
        System.out.println("=====================================");
        System.out.println("Customer App");
        System.out.println("(C) 2024");
        System.out.println("=====================================");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        final AppSettings appSettings = new AppSettings();
        final String host = appSettings.serverHost();
        final Integer port = appSettings.serverPort();
        final ClientBackend client = ClientBackend.getInstance();
        try {
            client.connect(host, port);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    System.out.println("Disconnecting from server...");
                    DisconnectAction disconnectAction = new DisconnectAction();
                    disconnectAction.execute();
                }
            });
            new FrontMenu().show();
        } catch (final IOException e) {
            System.out.println("Error connecting to host: " + host + " on port " + port);
        }

        // exiting the application, closing all threads
        System.exit(0);
    }
}
