package lapr4.jobs4u;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.protocol.ProtocolMessage;

/**
 * @author 2DI2
 */
public class EventListener {

    private static EventListener instance;
    private Map<SystemUser, List<Socket>> clientSockets;
    private Map<SystemUser, List<ProtocolMessage>> notifications;

    private EventListener() {
        this.clientSockets = new HashMap<>();
        this.notifications = new HashMap<>();
    }

    public synchronized void addClient(final SystemUser username, final Socket socket) {
        List<Socket> list = clientSockets.get(username);

        if (list == null) {
            list = new ArrayList<>();
            clientSockets.put(username, list);
        }

        list.add(socket);
    }

    public synchronized void removeClient(final Socket socket) {

        for (final SystemUser username : clientSockets.keySet()) {
            List<Socket> list = clientSockets.get(username);

            if (list != null)
                list.remove(socket);
        }
    }

    public synchronized Optional<SystemUser> user(final Socket socket) {
        for (final SystemUser username : clientSockets.keySet()) {
            List<Socket> list = clientSockets.get(username);

            if (list != null && list.contains(socket))
                return Optional.of(username);
        }

        return Optional.empty();
    }

    public synchronized void addNotification(final SystemUser id, final ProtocolMessage message) {
        List<ProtocolMessage> queue = notifications.get(id);

        if (queue == null) {
            queue = new LinkedList<>();
            notifications.put(id, queue);
        }

        queue.add(message);
    }

    public synchronized void removeNotification(final SystemUser id, final ProtocolMessage message) {
        List<ProtocolMessage> queue = notifications.get(id);
        if (queue != null) {
            queue.remove(message);
        }
    }

    public synchronized Optional<List<ProtocolMessage>> notifications(final SystemUser id) {
        final List<ProtocolMessage> list = notifications.get(id);
        return list == null ? Optional.empty() : Optional.of(new ArrayList<>(list));
    }

    public static synchronized EventListener getInstance() {
        if (instance == null) {
            instance = new EventListener();
        }
        return instance;
    }
}
