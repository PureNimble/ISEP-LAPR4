package lapr4.jobs4u;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class TcpH2 {

    private static final String SERVER_ADDRESS = "vsgate-s3.dei.isep.ipp.pt";
    private static final int SERVER_PORT = 10850;
    private static Socket socket;
    private static DataOutputStream output;
    private static DataInputStream input;

    public TcpH2() {
    }

    private void send(final ProtocolMessage msg) throws IOException {
        output.write(msg.toByteStream());
    }

    private ProtocolMessage receive() throws IOException, ClassNotFoundException {
        return ProtocolMessage.fromDataStream(input);
    }

    public ProtocolMessage sendRecv(final ProtocolMessage msg) {
        ProtocolMessage response = null;
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            send(msg);
            response = receive();
            disconnect();
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void disconnect() throws IOException {
        output.close();
        input.close();
        socket.close();
    }
}