package lapr4.jobs4u;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class TcpClient {

    private int port;
    private Class<? extends Runnable> handlerClass;
    private boolean secure;
    private EventListener eventListener;

    public TcpClient(int port, Class<? extends Runnable> handler, boolean secure) {
        this.port = port;
        this.handlerClass = handler;
        this.secure = secure;
        this.eventListener = new EventListener();
    }

    public void run() {

        ServerSocket tcpSocket;
        Socket socket;

        try {
            if (this.secure) {
                tcpSocket = SSLServerSocketFactory.getDefault().createServerSocket(port);
                SSLServerSocket sslListener = (SSLServerSocket) tcpSocket;
                sslListener.setNeedClientAuth(true);
            } else
                tcpSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error creating the tcp socket");
            e.printStackTrace();
            return;
        }

        System.out.printf("[TCP%s Server] Listening on port %d!\n", this.secure ? " SSL" : "", port);

        while (!tcpSocket.isClosed()) {
            try {
                socket = tcpSocket.accept();
                Runnable handler = handlerClass.getConstructor(Socket.class, EventListener.class)
                        .newInstance(socket, this.eventListener);
                Thread clientHandler = new Thread(handler);

                clientHandler.start();
            } catch (Exception e) {
                System.out.println("Error creating the client handler thread");
                e.printStackTrace();
            }
        }

        try {
            tcpSocket.close();
        } catch (IOException e) {
            System.out.println("Error closing the tcp socket");
            e.printStackTrace();
        }
    }
}
