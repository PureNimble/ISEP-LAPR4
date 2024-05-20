package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class DisconnMessage extends Message {
    public DisconnMessage(ProtocolMessage protocolMessage, DataOutputStream output, Socket socket,
            EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
        close();
    }
}