package lapr4.jobs4u.app.common;

import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public interface NotificationHandler {
    public void handle(final ProtocolMessage message);
}
