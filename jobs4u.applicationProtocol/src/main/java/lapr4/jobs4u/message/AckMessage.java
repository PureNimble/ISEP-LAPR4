package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class AckMessage extends Message {

    public AckMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() {
        // nothing to do
    }
}
