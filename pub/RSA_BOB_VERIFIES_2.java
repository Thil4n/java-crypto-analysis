import java.nio.file.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSA_BOB_VERIFIES_2 {
    public static void main(String[] args) throws Exception {
        // Step 1: Load Bob's private key (for decryption)
        String bobPrivateKeyStr = new String(Files.readAllBytes(Paths.get("bob_pvt_key")));
        byte[] bobPrivateKeyBytes = Base64.getDecoder().decode(bobPrivateKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey bobPrivateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bobPrivateKeyBytes));

        // Step 2: Load Alice's public key (for signature verification)
        String alicePublicKeyStr = new String(Files.readAllBytes(Paths.get("alice_pub_key")));
        byte[] alicePublicKeyBytes = Base64.getDecoder().decode(alicePublicKeyStr);
        PublicKey alicePublicKey = keyFactory.generatePublic(new X509EncodedKeySpec(alicePublicKeyBytes));

        // Step 3: Encrypted message received (Base64 encoded)
        String encryptedMessageBase64 = ""; // Replace this with the actual encrypted message received from Alice
        byte[] encryptedMessage = Base64.getDecoder().decode(encryptedMessageBase64);

        // Step 4: Decrypt the message using Bob's private key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, bobPrivateKey);
        byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessage);
        String decryptedMessage = new String(decryptedMessageBytes);

        // Step 5: Extract the original message and the signature
        String[] parts = decryptedMessage.split(":");
        String originalMessage = parts[0]; // The original message
        String signedMessageBase64 = parts[1]; // The Base64-encoded signature

        // Decode the Base64-encoded signature
        byte[] signedMessage = Base64.getDecoder().decode(signedMessageBase64);

        // Step 6: Verify the signature using Alice's public key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(alicePublicKey);
        signature.update(originalMessage.getBytes());
        boolean isVerified = signature.verify(signedMessage);

        // Print the result
        System.out.println("Original Message: " + originalMessage);
        if (isVerified) {
            System.out.println("The message signature is valid.");
        } else {
            System.out.println("The message signature is invalid.");
        }
    }
}