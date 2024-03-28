package tcp.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        String string = "Hello World";
        byte[] b = string.getBytes();
        DatagramPacket packet = new DatagramPacket(b, b.length, address, 9090);
        socket.send(packet);
        socket.close();
    }
}
