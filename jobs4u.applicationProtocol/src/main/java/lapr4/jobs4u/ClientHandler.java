package lapr4.jobs4u;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.message.AckMessage;
import lapr4.jobs4u.message.AuthMessage;
import lapr4.jobs4u.message.CommTestMessage;
import lapr4.jobs4u.message.DisconnMessage;
import lapr4.jobs4u.message.ErrMessage;
import lapr4.jobs4u.message.Message;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class ClientHandler implements Runnable {

    // ? define here the handler for the pretended message code
    private final static Map<MessageCode, Class<? extends Message>> MESSAGE_MAP = new HashMap<>() {
        {
            put(MessageCode.ACK, AckMessage.class);
            put(MessageCode.COMMTEST, CommTestMessage.class);
            put(MessageCode.DISCONN, DisconnMessage.class);
            put(MessageCode.ERR, ErrMessage.class);
            put(MessageCode.AUTH, AuthMessage.class);
        }
    };

    private final Logger logger = LogManager.getLogger(ClientHandler.class);

    private Socket client;
    private EventListener eventListener;

    public ClientHandler(Socket socket, EventListener eventListener) {
        this.client = socket;
        this.eventListener = eventListener;
    }

    @Override
    public void run() {

    }

    private void processMessage(ProtocolMessage message, DataOutputStream output) throws IOException {
        
    }
}
