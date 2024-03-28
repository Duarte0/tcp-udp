package udp.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Timestamp;

public class Server extends Thread {
    public static void main(String[] args) throws IOException {

        @SuppressWarnings("resource")
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] b = new byte[1042];
        DatagramPacket receivePacket;

        System.out.println("Server on");

        while (true) {
            receivePacket = new DatagramPacket(b, b.length);
            socket.receive(receivePacket);
            InetAddress address = receivePacket.getAddress();

            int port = receivePacket.getPort();

            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            System.out.println("[" + timestamp + "]" + address + port + " - " + clientMessage);
             
        }
    }
}
