package lapr4.jobs4u;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import lapr4.jobs4u.usermanagement.domain.BasePasswordPolicy;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class ClientApp {
    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
        AppSettings appSettings = new AppSettings();

        boolean isSecure = appSettings.isSSLEnabled();
        Integer port = appSettings.boardServerPort();

        TcpClient server = new TcpClient(port, ClientHandler.class, isSecure);
        server.run();
    }
}