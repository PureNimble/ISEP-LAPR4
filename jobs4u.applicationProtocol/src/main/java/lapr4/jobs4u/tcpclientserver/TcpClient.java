package lapr4.jobs4u.tcpclientserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

    private static InetAddress serverIP;
	private static Socket socket;

    public static void main(String[] args) throws Exception {
        
        if (args.length != 1) {
            System.out.println("Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }

        try {
            socket = new Socket(serverIP, 9999);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }
    }
}
