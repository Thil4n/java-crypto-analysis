import java.nio.file.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSA_ALICE_SIGNS {
    public static void main(String[] args) throws Exception {
        // Load Alice's private key from file
        String privateKeyStr = new String(Files.readAllBytes(Paths.get("alice_pvt_key")));
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // Message to sign
        String message = "This is a secret message from Alice.";

        // Sign the message using Alice's private key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signedMessage = signature.sign();

        // Encode signed message to Base64 for sending
        String signedMessageBase64 = Base64.getEncoder().encodeToString(signedMessage);

        // Print the message and signature (in Base64)
        System.out.println("Original Message: " + message);
        System.out.println("Signed Message (Base64 Encoded): " + signedMessageBase64);
    }
}