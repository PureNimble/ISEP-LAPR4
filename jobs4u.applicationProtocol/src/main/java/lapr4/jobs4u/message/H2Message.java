package lapr4.jobs4u.message;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;
import lapr4.jobs4u.usermanagement.application.ListUsersController;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Arrays;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

/**
 * @author 2DI2
 */
public class H2Message extends Message {

    public H2Message(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final ListUsersController listUsersController = new ListUsersController(
                PersistenceContext.repositories().users());

        final byte[][] dataChunks = request.datachunks();

        final String username = new String(dataChunks[0], StandardCharsets.UTF_8);

        final Optional<SystemUser> user = listUsersController.find(Username.valueOf(username));

        if (!user.isPresent())
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "User not found"));

        byte[][] message = Arrays.copyOfRange(dataChunks, 1, dataChunks.length);
        final SystemUser systemUser = user.get();

        eventListener.addNotification(systemUser, new ProtocolMessage((byte) 1, MessageCode.NOTIFICATION, message));

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
    }
}
