package lapr4.jobs4u.message;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;

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

        final byte[][] dataChunks = request.datachunks();

        StringBuilder dataBuilder = new StringBuilder();
        for (final byte[] chunk : dataChunks) {
            dataBuilder.append(new String(chunk, StandardCharsets.US_ASCII));
        }
        final String data = dataBuilder.toString();
        System.out.println("Received data: " + data);

        /*
         * if (true) {
         * final SystemUser user = null;
         * eventListener.addNotification(user, new ProtocolMessage((byte) 1,
         * MessageCode.NOTIFICATION, "null"));
         * // TODO: add notification
         * } else
         * send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Error"));
         */

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
    }
}
