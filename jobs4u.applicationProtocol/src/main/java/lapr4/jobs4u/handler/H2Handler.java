package lapr4.jobs4u.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.message.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class H2Handler implements Runnable {

	private final Logger LOGGER = LogManager.getLogger(H2Handler.class);

	private Socket socket;
	private EventListener eventListener;

	public H2Handler(final Socket socket, final EventListener eventListener) {
		this.socket = socket;
		this.eventListener = eventListener;
	}

	@Override
	public void run() {
		try {
			LOGGER.info("[H2 Handler Thread] Connected to " + socket.getInetAddress().getHostAddress() + " port "
					+ socket.getPort() + "!");

			final DataInputStream input = new DataInputStream(socket.getInputStream());
			final DataOutputStream output = new DataOutputStream(socket.getOutputStream());

			while (!socket.isClosed()) {
				try {
					final ProtocolMessage message = ProtocolMessage.fromDataStream(input);

					if (message == null)
						break;

					LOGGER.info("\n" + message.toString());

					processMessage(message, output);
				} catch (final Exception e) {
					new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"), output, socket,
							eventListener).handle();
				}
			}

			LOGGER.info("Connection closed.");

			output.close();
			input.close();
		} catch (final IOException e) {
			LOGGER.info("\n[H2 Handler Thread] Error", e.getMessage());
		}
	}

	private void processMessage(final ProtocolMessage message, final DataOutputStream output) throws IOException {
		Message handleMessage;

		try {
			handleMessage = new H2Message(message, output, socket, eventListener);
		} catch (final Exception e) {
			LOGGER.info("\n[H2 Handler Thread] Error", e.getMessage());
			return;
		}
		handleMessage.handle();
	}
}
