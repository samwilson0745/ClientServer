package ClientServer.Socket;

import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true);
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;

            System.out.println("Enter text (type 'exit' to quit): ");
            while ((userInput = consoleReader.readLine()) != null) {
                writer.println(userInput);
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
