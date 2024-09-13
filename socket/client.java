import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class client {

    final static int PORT = 4444;
    final static String HOST = "localhost";

    public static void main(String[] args) {

        try {
            Socket s = new Socket(HOST, PORT);

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello from client!");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String resp = in.readLine();
            System.out.println(resp);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}