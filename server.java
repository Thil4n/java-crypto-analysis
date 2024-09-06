import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class server {

    final static int PORT = 4444;

    public static void main(String[] args) throws IOException {
        System.out.println("Server is listening on port " + PORT + "!");

        ServerSocket ss = new ServerSocket(PORT);

        while (true) {
            // Wait for a connection
            Socket s = ss.accept();

            // Handle the connection
            System.out.println("A client connected!");

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello from server!");

            // Close the connection
            s.close();
        }
    }
}
