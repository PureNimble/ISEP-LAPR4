package lapr4.jobs4u.message;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.ProtocolMessage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 2DI2
 */
public class ListAppResMessage extends Message {

    public ListAppResMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        // nothing to do
    }
}
