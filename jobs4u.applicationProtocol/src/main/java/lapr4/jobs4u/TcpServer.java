package lapr4.jobs4u;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.application.DatabasePollingService;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

/**
 * @author 2DI2
 */
public class TcpServer {

    private final Logger LOGGER = LogManager.getLogger(TcpServer.class);
    private int port;
    private Class<? extends Runnable> handlerClass;
    private EventListener eventListener;

    public TcpServer(final int port, final Class<? extends Runnable> handler) {
        this.port = port;
        this.handlerClass = handler;
        this.eventListener = new EventListener();
    }

    public void run() {

        ServerSocket tcpSocket;
        Socket socket;

        try {
            tcpSocket = new ServerSocket(port);
            LOGGER.info(String.format("[TCP Server] Listening on port %d!\n", port));
        } catch (final IOException e) {
            LOGGER.info("Error creating the tcp socket");
            return;
        }

        try {
            final Runnable pollService = new DatabasePollingService(
                    PersistenceContext.repositories().recruitmentProcesses(),
                    PersistenceContext.repositories().customerUsers(),
                    this.eventListener);
            final Thread databasePollingService = new Thread(pollService);
            databasePollingService.start();

        } catch (final Exception e) {
            LOGGER.info("Error creating the database polling service: " + e.getMessage());
        }

        while (!tcpSocket.isClosed()) {
            try {

                socket = tcpSocket.accept();

                final Runnable handler = handlerClass.getConstructor(Socket.class, EventListener.class).newInstance(
                        socket, this.eventListener);

                final Thread clientHandler = new Thread(handler);

                clientHandler.start();
            } catch (final Exception e) {
                LOGGER.info("Error creating the client handler thread");
            }
        }

        try {
            tcpSocket.close();
        } catch (final IOException e) {
            LOGGER.info("Error closing the tcp socket");
        }
    }
}
