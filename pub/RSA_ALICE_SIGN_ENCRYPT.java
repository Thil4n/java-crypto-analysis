import java.nio.file.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSA_ALICE_SIGN_ENCRYPT {
    public static void main(String[] args) throws Exception {
        // Load Alice's private key from file (for signing)
        String privateKeyStr = new String(Files.readAllBytes(Paths.get("alice_pvt_key")));
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // Load Bob's public key from file (for encrypting)
        String publicKeyStr = new String(Files.readAllBytes(Paths.get("bob_pub_key")));
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        PublicKey bobPublicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        // Message to sign and encrypt
        String message = "This is a secret message from Alice.";

        // Step 1: Sign the message using Alice's private key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signedMessage = signature.sign();

        // Combine the original message and signature
        String messageWithSignature = message + ":" + Base64.getEncoder().encodeToString(signedMessage);

        // Step 2: Encrypt the signed message using Bob's public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, bobPublicKey);
        byte[] encryptedMessage = cipher.doFinal(messageWithSignature.getBytes());

        // Encode encrypted message to Base64 for easy transport
        String encryptedMessageBase64 = Base64.getEncoder().encodeToString(encryptedMessage);

        // Print the encrypted message
        System.out.println("Encrypted Message (Base64 Encoded): " + encryptedMessageBase64);
    }
}