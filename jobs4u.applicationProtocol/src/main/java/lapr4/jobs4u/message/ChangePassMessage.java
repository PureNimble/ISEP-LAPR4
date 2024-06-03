package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class ChangePassMessage extends Message {

    public ChangePassMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final AuthenticationCredentialHandler credentialHandler = new AuthenticationCredentialHandler();
        final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
        final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

        final byte[][] dataChunks = request.datachunks();
        if (dataChunks.length < 2) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"), output, socket,
                    eventListener).handle();
            return;
        }
        final Optional<SystemUser> userOpt = eventListener.user(socket);
        if (userOpt.isEmpty()) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Something went wrong"), output, socket,
                    eventListener).handle();
            return;
        }
        final SystemUser user = userOpt.get();
        final String oldPassword = new String(dataChunks[0], StandardCharsets.US_ASCII);
        final String newPassword = new String(dataChunks[1], StandardCharsets.US_ASCII);

        if (!credentialHandler.authenticated(user.username().toString(), oldPassword,
                user.roleTypes().stream().findFirst().get())) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid authentication"));
            return;
        }

        try {
            if (!authenticationService.changePassword(oldPassword, newPassword)) {
                send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid authentication"));
                return;
            }
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "An error has occurred"));
        }

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
        authorizationService.clearSession();
    }
}