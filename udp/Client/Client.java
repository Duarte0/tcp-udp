

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

         DatagramPacket packet;
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buf;

        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(1000);
        System.out.println("Type a message to send to the server.");
        System.out.println("Type 'exit' to exit.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String cmd = scanner.nextLine();

            if (cmd.equals("exit")) {
                socket.close();
                System.exit(1);
                scanner.close();
            }

            buf = cmd.getBytes();
            packet = new DatagramPacket(buf, buf.length, address, 9090);
            socket.send(packet);
        }
    }
}
