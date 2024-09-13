import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class server2 {

    final static int PORT = 4444;

    public static void main(String[] args) throws IOException {
        System.out.println("Server is listening on port " + PORT + "!");

        // Create a server socket to listen for incoming connections
        ServerSocket ss = new ServerSocket(PORT);

        while (true) {
            // Wait for a client to connect
            Socket s = ss.accept();
            System.out.println("A client connected!");

            // Create output stream to send a message to the client
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello from server!");

            // Create input stream to receive messages from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // Loop to handle continuous communication with the client
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                // Print the client's message to the console
                System.out.println("Client: " + clientMessage);

                // Respond to the client
                out.println("Server received: " + clientMessage);
            }

            // Close the connection when client disconnects
            System.out.println("Client disconnected.");
            s.close();
        }
    }
}