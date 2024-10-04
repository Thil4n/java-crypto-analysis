import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "p455w07d";

        System.out.println("Original password: " + password);
        System.out.println("Password length: " + password.length());

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(password.getBytes());

        byte[] digest = md.digest();

        // Convert the byte array into a hex string
        StringBuilder hash = new StringBuilder();
        for (byte b : digest) {
            hash.append(String.format("%02x", b)); // Convert byte to hex
        }

        System.out.println("SHA-256 hash: " + hash.toString());
    }
}