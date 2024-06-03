package lapr4.jobs4u.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lapr4.jobs4u.EventListener;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class NotificationMessage extends Message {

    public NotificationMessage(final ProtocolMessage protocolMessage, final DataOutputStream output,
            final Socket socket, final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        eventListener.user(socket).ifPresent(user -> {
            eventListener.notifications(user).ifPresent(notifications -> {
                notifications.forEach(notification -> {
                    try {
                        send(notification);
                        eventListener.removeNotification(user, notification);
                    } catch (final Exception e) {
                        return;
                    }
                });
            });
        });

    }
}
