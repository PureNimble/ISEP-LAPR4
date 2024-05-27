package lapr4.jobs4u;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.protocol.ProtocolMessage;

public class EventListener {

    private Map<SystemUser, List<Socket>> clientSockets;

    public EventListener() {
        this.clientSockets = new HashMap<>();
    }

    public void addClient(final SystemUser username, final Socket socket) {
        List<Socket> list = clientSockets.get(username);

        if (list == null) {
            list = new ArrayList<>();
            clientSockets.put(username, list);
        }

        list.add(socket);
    }

    public void removeClient(final Socket socket) {

        for (final SystemUser username : clientSockets.keySet()) {
            List<Socket> list = clientSockets.get(username);

            if (list != null)
                list.remove(socket);
        }
    }

    public void send(final SystemUser id, final ProtocolMessage message) {
        final List<Socket> clients = this.clientSockets.get(id);
        DataOutputStream out;

        if (clients != null) {
            for (final Socket client : clients) {
                try {
                    out = new DataOutputStream(client.getOutputStream());
                    out.write(message.toByteStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SystemUser user(final Socket socket) {
        for (final SystemUser username : clientSockets.keySet()) {
            List<Socket> list = clientSockets.get(username);

            if (list != null && list.contains(socket))
                return username;
        }

        return null;
    }
}
