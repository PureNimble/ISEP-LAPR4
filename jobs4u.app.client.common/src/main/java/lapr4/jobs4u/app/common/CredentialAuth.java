package lapr4.jobs4u.app.common;

import java.io.IOException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.infrastructure.authz.CredentialHandler;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.usermanagement.dto.SystemUserDTO;

public class CredentialAuth {

    private final Logger logger = LogManager.getLogger(CredentialAuth.class);

    private SystemUserDTO systemUser;

    public Optional<SystemUserDTO> systemUser() {
        return Optional.ofNullable(this.systemUser);
    }

    public void clear() {
        this.systemUser = null;
    }

    public final CredentialHandler AUTHENTICATE = (u, p, r) -> {

        final ClientBackend clientBackend = ClientBackend.getInstance();

        final MessageListener listener = clientBackend.listener();

        try {
            final ProtocolMessage response;
            try {
                response = listener.sendRecv(new ProtocolMessage((byte) 1, MessageCode.AUTH, u, p, r.toString()));
                logger.info("\n Protocol Version: " + response.protocolVersion() + "\n Message Code: "
                        + response.code().toString());
                if (response.code() == MessageCode.ACK) {
                    Object[] responseData = (Object[]) response.dataAsObjects();
                    systemUser = (SystemUserDTO) responseData[0];
                    return true;
                }
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            }

            return false;
        } catch (final IOException e) {
            logger.error("Error while authenticating", e.getMessage());
            return false;
        }
    };
}