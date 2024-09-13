import java.nio.file.*;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA_BOB_VERIFIES {
    public static void main(String[] args) throws Exception {
        // Load Alice's public key from file
        String publicKeyStr = new String(Files.readAllBytes(Paths.get("alice_pub_key")));
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        // Original message received
        String message = "This is a secret message from Alice.";

        // The signed message received (Base64 encoded)
        String signedMessageBase64 = ""; // Replace
                                         // this
                                         // with
                                         // the
                                         // actual
                                         // signature
                                         // from
        // Alice

        // Decode the Base64-encoded signed message
        byte[] signedMessage = Base64.getDecoder().decode(signedMessageBase64);

        // Verify the signature using Alice's public key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean isVerified = signature.verify(signedMessage);

        // Print verification result
        if (isVerified) {
            System.out.println("The message signature is valid.");
        } else {
            System.out.println("The message signature is invalid.");
        }
    }
}