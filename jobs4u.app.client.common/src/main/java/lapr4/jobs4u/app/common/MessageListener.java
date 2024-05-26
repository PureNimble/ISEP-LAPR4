package lapr4.jobs4u.app.common;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.ProtocolMessage;

public class MessageListener implements Runnable {

    private static Logger logger = LogManager.getLogger(MessageListener.class);

    private TcpClient tcpClient;

    public MessageListener(TcpClient tcpClient) {
        this.tcpClient = tcpClient;
    }

    public void run() {
        while (true) {

            /* try {
                final ProtocolMessage incoming = tcpClient.receive();
                logger.info("Received message: " + incoming.toString());
            } catch (final ClassNotFoundException | IOException e) {
                logger.info("Error while receiving message" + e.getMessage());
            } */
            
        }
    }

    private ProtocolMessage receive() throws ClassNotFoundException, IOException {
        return tcpClient.receive();
    }

    private void send(final ProtocolMessage msg) throws IOException {
        tcpClient.send(msg);
    }

    public ProtocolMessage sendRecv(final ProtocolMessage msg)
            throws IOException, ClassNotFoundException {
        synchronized (this) {
            send(msg);
            return receive();
        }
    }
}