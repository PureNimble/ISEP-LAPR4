package lapr4.jobs4u;

public class ServerApp {
    public static void main(String[] args) {
        final AppSettings appSettings = new AppSettings();
        final Integer port = appSettings.serverPort();
        final TcpServer server = new TcpServer(port, ClientHandler.class);
        server.run();
    }
}