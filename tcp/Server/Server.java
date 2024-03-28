package tcp.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket server = new DatagramSocket(9090);
        byte[] b = new byte[256];
        DatagramPacket packet = new DatagramPacket(b, b.length);
        server.receive(packet);
        String response = new String(packet.getData());
        System.out.println("Response Data: " +  response);
        server.close();
    }
}
