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
        String signedMessageBase64 = "Mmnldv4xUxQmu0gjGvWFkuYTe78GG0D4KeJ/yf4R6OGRHu7dz4umViUaXcYcr482CKTJTGhWpLSY0nWk/pk3VRF2KgvDAGejYLiOhoUxi2s9TWgiZsKX/Pzn+0FEAggUzmoh2z7SWnSlPgdVufKKb28/207TjQAB45Jco4g0iAumhHjnpG+JAeAlIN+TP24hr3LyajP6/CCimzk7l5gSDE/fviK66Oz0VQDPHeXXnpLnD03pHZDVD2h466LM4qJWRYJzhVXIV8Mkjb5Eyw3olK1IVQ3oJzD989WmP4/C53xhKzBfpwb2rv043gsPYZ1lxoZqKMtGvAjKo8GMDs6oGg=="; // Replace
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