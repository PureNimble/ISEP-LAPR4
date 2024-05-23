package lapr4.jobs4u;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class ClientApp {
    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
        final AppSettings appSettings = new AppSettings();
        final Integer port = appSettings.serverPort();
        final TcpServer server = new TcpServer(port, ClientHandler.class);
        server.run();
    }
}