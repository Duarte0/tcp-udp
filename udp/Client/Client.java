package udp.Client;

import java.net.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Client {
    public static void main(String args[]) throws Exception {

        // conexao e comunicacao
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            // estabelece conexao
            socket = new Socket("localhost", 8080);

            // conversao byte para caractere
            inputStreamReader = new InputStreamReader((socket.getInputStream()));
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            // leitura e escrita
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            try (Scanner scanner = new Scanner(System.in)) {
                //permite troca de mensagem
                while (true) {
                    String message = scanner.nextLine();
                    bufferedWriter.write(message);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    System.out.println("Server: " + bufferedReader.readLine());

                    if (message.equalsIgnoreCase("exit"))
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (outputStreamWriter != null)
                    outputStreamWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}