package udp.Client;

import java.util.*;
import java.net.*;

public class Client {
    public static void main(String args[]) throws Exception{
        DatagramSocket socket = new DatagramSocket();

        System.out.println("Digite uma mensagem: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
    }
    
}