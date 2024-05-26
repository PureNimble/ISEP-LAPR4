package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.usermanagement.dto.SystemUserDTO;

public class AuthMessage extends Message {

    public AuthMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final AuthenticationCredentialHandler credentialHandler = new AuthenticationCredentialHandler();
        final UserManagementService userSvc = AuthzRegistry.userService();

        byte[][] dataChunks = request.datachunks();

        if (dataChunks.length < 2) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.BADREQUEST), output, socket, eventListener).handle();
            return;
        }

        final String usernameStr = new String(dataChunks[0], StandardCharsets.US_ASCII);
        final String passwordStr = new String(dataChunks[1], StandardCharsets.US_ASCII);
        final String role = new String(dataChunks[2], StandardCharsets.US_ASCII);

        if (!credentialHandler.authenticated(usernameStr, passwordStr, Role.valueOf(role))) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        final Optional<SystemUser> optional = userSvc.userOfIdentity(Username.valueOf(usernameStr));

        if (!optional.isPresent()) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        final SystemUser systemUser = optional.get();

        final SystemUserDTO systemUserDTO = new SystemUserDTO(systemUser.username().toString(),
                systemUser.name().toString(), systemUser.email().toString(), systemUser.roleTypes().toString());

        send(new ProtocolMessage((byte) 1, MessageCode.ACK, systemUserDTO));

        eventListener.addClient(usernameStr, socket);
    }
}
