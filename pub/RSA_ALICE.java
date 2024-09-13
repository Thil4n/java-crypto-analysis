import java.security.*;
import java.util.Base64;
import java.nio.file.*;

public class RSA_ALICE {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPairGenerator key_gen = KeyPairGenerator.getInstance("RSA");
        key_gen.initialize(2048);
        KeyPair key_pair = key_gen.generateKeyPair();

        // Encode keys to Base64
        String publicKey = Base64.getEncoder().encodeToString(key_pair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(key_pair.getPrivate().getEncoded());

        // Save public key to file
        Files.write(Paths.get("alice_pub_key"), publicKey.getBytes());

        // Save private key to file
        Files.write(Paths.get("alice_pvt_key"), privateKey.getBytes());

        System.out.println("Keys saved to files.");
    }
}