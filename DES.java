import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.security.spec.InvalidKeySpecException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;

public class DES {
    public static void main(String[] args) {

        try {
            String custom_key = "12345678"; // DES requires 8-byte key
            DESKeySpec key_spec = new DESKeySpec(custom_key.getBytes());
            SecretKeyFactory key_factory = SecretKeyFactory.getInstance("DES");
            SecretKey key = key_factory.generateSecret(key_spec);

            byte[] key_bytes = key.getEncoded();
            String key_str = Base64.getEncoder().encodeToString(key_bytes);

            System.out.println("Encoded Key: " + key_str);

            // Decoding the key
            byte[] decoded_key = Base64.getDecoder().decode(key_str);
            key_spec = new DESKeySpec(decoded_key);
            key = key_factory.generateSecret(key_spec);
            key_bytes = key.getEncoded();
            key_str = Base64.getEncoder().encodeToString(key_bytes);
            System.out.println("Decoded Key: " + key_str);

            // Encryption
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipher_text = cipher.doFinal("Hello, World!".getBytes());
            String cipher_text_str = Base64.getEncoder().encodeToString(cipher_text);
            System.out.println("Cipher Text: " + cipher_text_str);

            // Decryption
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plain_text = cipher.doFinal(cipher_text);
            String plain_text_str = new String(plain_text);
            System.out.println("Plain Text: " + plain_text_str);

        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
                | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}