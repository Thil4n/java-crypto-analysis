import java.nio.charset.StandardCharsets;

public class Keccak256 {

    private static final int RATE = 136; // Rate in bytes for Keccak-256 (1088 bits)
    private static final int STATE_SIZE = 200; // State size in bytes for Keccak (1600 bits)
    private long[] state = new long[STATE_SIZE / 8]; // 200 bytes state
    private int position = 0;

    public Keccak256() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
        position = 0;
    }

    public void update(byte[] input) {
        for (byte b : input) {
            state[position / 8] ^= ((long) b & 0xFF) << (8 * (position % 8));
            position++;
            if (position == RATE) { // When position reaches 136 bytes
                absorb();
                position = 0;
            }
        }
    }

    private void absorb() {
        // Apply the Keccak-f permutation
        keccakF(state);
    }

    public byte[] digest() {
        // Padding the last block
        state[position / 8] ^= (0x01L << (8 * (position % 8))); // Pad with 1 at the position
        state[(position / 8) + (RATE - 1)] ^= 0x80; // Pad with 0x80 at the end of the rate

        // Final permutation
        keccakF(state);

        // Extract the output (32 bytes for Keccak-256)
        byte[] output = new byte[32]; // 256 bits / 8 = 32 bytes
        for (int i = 0; i < output.length; i++) {
            output[i] = (byte) (state[i / 8] >> (8 * (i % 8)));
        }
        return output;
    }

    private void keccakF(long[] state) {
        // Placeholder for Keccak-f permutation
        // You need to implement the full permutation logic here
        // Refer to the Keccak specification for details
    }

    public static void main(String[] args) {
        Keccak256 keccak256 = new Keccak256();
        String input = "Hello, world!";
        keccak256.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] hash = keccak256.digest();

        // Print the hash in hexadecimal format
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)

                hexString.append('0');
            hexString.append(hex);
        }

        System.out.println("Keccak-256 Hash: " + hexString.toString());
    }
}
