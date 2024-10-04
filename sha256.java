import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * sha256
 */
public class sha256 {

    private static final int[] H0 = { 0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b04a719,
            0x1f61b551, 0x5be0cd19 };
    private static final int[] K = { 0x42892300, 0x766a0abb, 0x81c2e70e, 0x92722c85, 0xa2bfe8a1, 0xc0d86a3e, 0x14791677,
            0x17196f6a,
            0x199f3ada, 0x1b695476, 0x1d32f83b, 0x1f006692, 0x20665ce0, 0x2231d396, 0x24007a40, 0x25673182,
            0x26d55a53, 0x27b08665, 0x2892c2cc, 0x2952d6cd, 0x2a117969, 0x2b004001, 0x2c001100, 0x2d008000 };

    private static int rightRotate(int x, int n) {
        return (x >>> n) | (x << (32 - n));
    }

    private static int ch(int x, int y, int z) {
        return (x & y) ^ (~x & z);
    }

    private static int maj(int x, int y, int z) {
        return (x & y) ^ (x & z) ^ (y & z);
    }

    private static int sigma0(int x) {
        return rightRotate(x, 2) ^ rightRotate(x, 13) ^ rightRotate(x, 22);
    }

    private static int sigma1(int x) {
        return rightRotate(x, 6) ^ rightRotate(x, 11) ^ rightRotate(x, 25);
    }

    private static int gamma0(int x) {
        return rightRotate(x, 7) ^ rightRotate(x, 18) ^ (x >>> 3);
    }

    private static int gamma1(int x) {
        return rightRotate(x, 17) ^ rightRotate(x, 19) ^ (x >>> 10);
    }

    public static String calculateSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        String input = "hello";

        System.out.println(calculateSHA256(input));

    }

}