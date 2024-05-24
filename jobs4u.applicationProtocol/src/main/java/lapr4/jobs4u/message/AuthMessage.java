package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import lapr4.jobs4u.infrastructure.authz.CredentialHandler;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class AuthMessage extends Message {

    public AuthMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final CredentialHandler credentialHandler = new AuthenticationCredentialHandler();
        final UserManagementService userSvc = AuthzRegistry.userService();

        byte[][] dataChunks = request.datachunks();

        if (dataChunks.length < 2) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"));
            return;
        }

        final String usernameStr = new String(dataChunks[0], StandardCharsets.US_ASCII);
        final String passwordStr = new String(dataChunks[1], StandardCharsets.US_ASCII);

        if (!credentialHandler.authenticated(usernameStr, passwordStr, null)) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        final Optional<SystemUser> optional = userSvc.userOfIdentity(Username.valueOf(usernameStr));

        if (!optional.isPresent()) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));

    }
}
