package lapr4.jobs4u;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.ProtocolMessage;

public class TcpClient {

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    private final Logger logger = LogManager.getLogger(TcpClient.class);

    public TcpClient() {
    }

    public void connect(final String hostname, final int port) throws UnknownHostException, IOException {

        socket = new Socket(hostname, port);
        logger.debug("Connected to the server!");

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void send(final ProtocolMessage msg) throws IOException {
        output.write(msg.toByteStream());
    }

    public ProtocolMessage receive() throws IOException, ClassNotFoundException {
        return ProtocolMessage.fromDataStream(input);
    }

    public ProtocolMessage sendRecv(final ProtocolMessage msg) throws IOException, ClassNotFoundException {
        synchronized (this) {
            send(msg);
            return receive();
        }
    }

    public void close() throws IOException {
        output.close();
        input.close();
        socket.close();
    }
}