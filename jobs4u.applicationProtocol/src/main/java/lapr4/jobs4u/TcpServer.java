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

    public TcpServer(int port, Class<? extends Runnable> handler) {
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
            logger.debug("Error creating the tcp socket");
            return;
        }

        logger.debug("[TCP%s Server] Listening on port %d!\n", port);

        while (!tcpSocket.isClosed()) {
            try {

                socket = tcpSocket.accept();

                Runnable handler = handlerClass.getConstructor(Socket.class, EventListener.class).newInstance(socket,
                        this.eventListener);

                Thread clientHandler = new Thread(handler);

                clientHandler.start();
            } catch (Exception e) {
                logger.debug("Error creating the client handler thread");
            }
        }

        try {
            tcpSocket.close();
        } catch (IOException e) {
            logger.debug("Error closing the tcp socket");
        }
    }
}
