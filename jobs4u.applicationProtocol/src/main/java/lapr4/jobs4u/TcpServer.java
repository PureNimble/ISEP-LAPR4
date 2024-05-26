package lapr4.jobs4u;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TcpServer {

    private final Logger logger = LogManager.getLogger(TcpServer.class);
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
        } catch (IOException e) {
            logger.info("Error creating the tcp socket");
            return;
        }

        logger.info(String.format("[TCP Server] Listening on port %d!\n", port));
        
        while (!tcpSocket.isClosed()) {
            try {

                socket = tcpSocket.accept();

                final Runnable handler = handlerClass.getConstructor(Socket.class, EventListener.class).newInstance(
                        socket, this.eventListener);

                final Thread clientHandler = new Thread(handler);

                clientHandler.start();
            } catch (final Exception e) {
                logger.info("Error creating the client handler thread");
            }
        }

        try {
            tcpSocket.close();
        } catch (final IOException e) {
            logger.info("Error closing the tcp socket");
        }
    }
}
