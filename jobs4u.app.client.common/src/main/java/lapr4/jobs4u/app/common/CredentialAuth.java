package lapr4.jobs4u.app.common;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.infrastructure.authz.CredentialHandler;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class CredentialAuth {

    private final Logger LOGGER = LogManager.getLogger(CredentialAuth.class);

    private String email;

    public String email() {
        return email;
    }

    public void clear() {
        this.email = null;
    }

    public final CredentialHandler AUTHENTICATE = (u, p, r) -> {

        final ClientBackend clientBackend = ClientBackend.getInstance();
        final MessageListener listener = clientBackend.listener();

        try {
            final ProtocolMessage response;
            try {
                response = listener.sendRecv(new ProtocolMessage((byte) 1, MessageCode.AUTH, u, p, r.toString()));
                LOGGER.info(response.toString());
                if (response.code() == MessageCode.ACK) {
                    email = u;
                    return true;
                }
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            }

            return false;
        } catch (final IOException e) {
            LOGGER.error("Error while authenticating", e.getMessage());
            return false;
        }
    };
}