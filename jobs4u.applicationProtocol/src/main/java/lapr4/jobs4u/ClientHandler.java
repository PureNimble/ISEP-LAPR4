package lapr4.jobs4u;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.message.AckMessage;
import lapr4.jobs4u.message.AuthMessage;
import lapr4.jobs4u.message.ChangePassMessage;
import lapr4.jobs4u.message.CommTestMessage;
import lapr4.jobs4u.message.DisconnMessage;
import lapr4.jobs4u.message.ErrMessage;
import lapr4.jobs4u.message.LogoutMessage;
import lapr4.jobs4u.message.Message;
import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class ClientHandler implements Runnable {

    private final static Map<MessageCode, Class<? extends Message>> MESSAGE_MAP = new HashMap<>() {
        {
            put(MessageCode.ACK, AckMessage.class);
            put(MessageCode.COMMTEST, CommTestMessage.class);
            put(MessageCode.DISCONN, DisconnMessage.class);
            put(MessageCode.ERR, ErrMessage.class);
            put(MessageCode.AUTH, AuthMessage.class);
            put(MessageCode.LOGOUT, LogoutMessage.class);
            put(MessageCode.CHANGEPASS, ChangePassMessage.class);
        }
    };

    private final Logger logger = LogManager.getLogger(ClientHandler.class);

    private Socket socket;
    private EventListener eventListener;

    public ClientHandler(final Socket socket, final EventListener eventListener) {
        this.socket = socket;
        this.eventListener = eventListener;
    }

    @Override
    public void run() {
        try {
            logger.info("[Client Handler Thread] Connected to "
                    + socket.getInetAddress().getHostAddress() + " port " + socket.getPort() + "!");

            final DataInputStream input = new DataInputStream(socket.getInputStream());
            final DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while (!socket.isClosed()) {
                try {
                    final ProtocolMessage message = ProtocolMessage.fromDataStream(input);

                    if (message == null)
                        break;

                    logger.info("\n" + message.toString());

                    processMessage(message, output);
                } catch (final Exception e) {
                    new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"), output, socket,
                            eventListener).handle();
                }
            }

            logger.info("Connection closed.");

            output.close();
            input.close();
        } catch (final IOException e) {
            logger.error("\n[Client Handler Thread] Error", e.getMessage());
        }
    }

    private void processMessage(final ProtocolMessage message, final DataOutputStream output) throws IOException {
        Message handleMessage;

        Class<? extends Message> clazz = MESSAGE_MAP.get(message.code());

        if (clazz == null) {
            handleMessage = new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"), output,
                    socket, eventListener);

        } else {
            try {
                handleMessage = clazz
                        .getDeclaredConstructor(ProtocolMessage.class, DataOutputStream.class, Socket.class,
                                EventListener.class)
                        .newInstance(message, output, this.socket, this.eventListener);
            } catch (final Exception e) {
                logger.error("\n[Client Handler Thread] Error", e);
                return;
            }
        }

        handleMessage.handle();
    }
}