package lapr4.jobs4u;

import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventListener {

    private Map<String, List<Socket>> subscriptions;
    private Map<String, List<Socket>> clientsSockets;

    public EventListener() {
        this.subscriptions = new HashMap<>();
        this.clientsSockets = new HashMap<>();
    }
}
