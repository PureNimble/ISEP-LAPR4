package lapr4.jobs4u.app.common;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.util.Pair;

import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class MessageListener implements Runnable {

    private static Logger LOGGER = LogManager.getLogger(MessageListener.class);

    private TcpClient tcpClient;
    private List<ProtocolMessage> queue;
    private Pair<MessageCode, NotificationHandler> events;

    public MessageListener(final TcpClient tcpClient) {
        this.tcpClient = tcpClient;
        this.queue = new LinkedList<>();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            try {
                final ProtocolMessage incoming = tcpClient.receive();
                final MessageCode code = incoming.code();

                if (code.equals(events.getFirst())) {
                    final NotificationHandler handler = events.getSecond();
                    handler.handle(incoming);
                } else {
                    synchronized (queue) {
                        queue.add(incoming);
                        queue.notifyAll();
                    }
                }

            } catch (final IOException e) {
                if (!Thread.currentThread().isInterrupted()) {
                    LOGGER.info("I/O error while receiving message: " + e.getMessage());
                    System.exit(1);
                }
                return;
            } catch (final ClassNotFoundException e) {
                if (Thread.currentThread().isInterrupted())
                    return;
                LOGGER.info("Error while receiving message: " + e.getMessage());
            }

        }
    }

    public ProtocolMessage receive() {

        while (true) {
            synchronized (queue) {
                for (final ProtocolMessage message : queue) {
                    queue.remove(message);
                    return message;
                }

                try {
                    queue.wait();
                } catch (final InterruptedException e) {
                    LOGGER.error("Error waiting for message", e);
                }
            }
        }
    }

    private void send(final ProtocolMessage msg) throws IOException {
        tcpClient.send(msg);
    }

    public void notification(final MessageCode code, final NotificationHandler handler) {
        events = Pair.of(code, handler);
    }

    public ProtocolMessage sendRecv(final ProtocolMessage msg)
            throws IOException, ClassNotFoundException {
        synchronized (this) {
            send(msg);
            return receive();
        }
    }
}