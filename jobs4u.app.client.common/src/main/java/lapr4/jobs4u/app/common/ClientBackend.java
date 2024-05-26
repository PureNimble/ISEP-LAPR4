package lapr4.jobs4u.app.common;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class ClientBackend {

    private final Logger logger = LogManager.getLogger(CredentialAuth.class);

    private static ClientBackend instance;
    private MessageListener listener;
    private final TcpClient tcpClient;
    private final CredentialAuth credentialAuth;

    public static ClientBackend getInstance() {
        if (instance == null) {
            synchronized (ClientBackend.class) {
                instance = new ClientBackend();
            }
        }

        return instance;
    }

    private ClientBackend() {
        this.tcpClient = new TcpClient();
        this.credentialAuth = new CredentialAuth();
    }

    public CredentialAuth credentialAuth() {
        return credentialAuth;
    }

    public MessageListener listener() {
        return listener;
    }

    public void connect(final String host, final int port) throws UnknownHostException, IOException {

        tcpClient.connect(host, port);
        logger.info("Sending a test message to the server");
        final ProtocolMessage response;
        try {
            response = tcpClient.sendRecv(new ProtocolMessage((byte) 1, MessageCode.COMMTEST));
            logger.info("Received response from server: " + response.toString());
        } catch (ClassNotFoundException | IOException e) {
            logger.error("Error sending test message to server: " + e.getMessage());
        }

        listener = new MessageListener(tcpClient);

        final Thread listenerThread = new Thread(listener);
        listenerThread.start();
    }

    public boolean disconnect() throws IOException, ClassNotFoundException {
        final ProtocolMessage response = tcpClient.sendRecv(new ProtocolMessage((byte) 1, MessageCode.DISCONN));
        if (response.code() == MessageCode.ACK) {
            tcpClient.disconnect();
            logger.info("Disconnected from the server");
            return true;
        }
        return false;
    }
}