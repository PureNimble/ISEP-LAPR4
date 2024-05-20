package lapr4.jobs4u;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.ProtocolMessage;

public class TcpClient {

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    private final Logger logger = LogManager.getLogger(TcpClient.class);

    protected TcpClient() {
    }

    public void connect(String hostname, int port, boolean secure) throws UnknownHostException, IOException {

        if (secure) {
            socket = SSLSocketFactory.getDefault().createSocket(hostname, port);

            SSLParameters sslParams = new SSLParameters();
            sslParams.setEndpointIdentificationAlgorithm("HTTPS");
            ((SSLSocket) socket).setSSLParameters(sslParams);

            ((SSLSocket) socket).startHandshake();
        } else {
            socket = new Socket(hostname, port);
        }

        logger.debug("Connected to the server!");

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void send(ProtocolMessage msg) throws IOException {
        output.write(msg.toByteStream());
    }

    public ProtocolMessage receive() throws IOException, ClassNotFoundException {
        return ProtocolMessage.fromDataStream(input);
    }

    public ProtocolMessage sendRecv(ProtocolMessage msg) throws IOException, ClassNotFoundException {
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