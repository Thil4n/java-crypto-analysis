import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class client2 {

    final static int PORT = 4444;
    final static String HOST = "localhost";

    public static void main(String[] args) {

        try {
            // Connect to the server
            Socket s = new Socket(HOST, PORT);

            // Set up input and output streams
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Receive and print the initial message from the server
            String serverResponse = serverInput.readLine();
            System.out.println("Server: " + serverResponse);

            // Get user input and send to the server
            String userMessage;
            System.out.print("Enter a message: ");
            while ((userMessage = userInput.readLine()) != null && !userMessage.equalsIgnoreCase("exit")) {
                // Send user input to the server
                out.println(userMessage);

                // Read and print the server's reply
                serverResponse = serverInput.readLine();
                System.out.println("Server: " + serverResponse);

                // Prompt for the next message
                System.out.print("Enter a message: ");
            }

            // Close the connection
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}