package lapr4.jobs4u;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import lapr4.jobs4u.handler.ClientHandler;
import lapr4.jobs4u.handler.H2Handler;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

/**
 * @author 2DI2
 */
public class ServerApp {
    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());

        final AppSettings appSettings = new AppSettings();

        final Integer serverClientPort = appSettings.serverPort();
        final TcpServer serverClient = new TcpServer(serverClientPort, ClientHandler.class);
        final Thread serverClientThread = new Thread(serverClient::run);
        serverClientThread.start();

        final Integer serverH2Port = appSettings.h2ServerPort();
        final TcpServer serverH2 = new TcpServer(serverH2Port, H2Handler.class);
        final Thread serverH2Thread = new Thread(serverH2::run);
        serverH2Thread.start();
    }
}