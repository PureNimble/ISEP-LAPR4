package lapr4.jobs4u.app.common;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class ClientBackend {

    private final Logger LOGGER = LogManager.getLogger(ClientBackend.class);

    private static ClientBackend instance;
    private MessageListener listener;
    private final TcpClient tcpClient;
    private final CredentialAuth credentialAuth;
    private Thread listenerThread;

    public static ClientBackend getInstance() {
        synchronized (ClientBackend.class) {
            if (instance == null) {
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

        listener = new MessageListener(tcpClient);

        listener.notification(MessageCode.NOTIFICATION, (notification) -> {
            LOGGER.info("Received message from server: " + notification.toString());
            final String message = new String(notification.datachunks()[0], StandardCharsets.US_ASCII);
            System.out.printf(
                    "\n--------------------------- NOTIFICATION ---------------------------\n%s\n--------------------------------------------------------------------\n\n",
                    message);
        });

        listenerThread = new Thread(listener);
        listenerThread.start();

        LOGGER.info("Sending a test message to the server");
        final ProtocolMessage response;
        try {
            response = listener.sendRecv(new ProtocolMessage((byte) 1, MessageCode.COMMTEST));
            LOGGER.info("Received response from server: " + response.toString());
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.error("Error sending test message to server: " + e.getMessage());
        }
    }

    public void disconnect() throws IOException, ClassNotFoundException {
        final ProtocolMessage response = listener.sendRecv(new ProtocolMessage((byte) 1, MessageCode.DISCONN));
        if (response.code() == MessageCode.ACK) {
            LOGGER.info(response.toString());
            listenerThread.interrupt();
            tcpClient.disconnect();
        }
    }
}