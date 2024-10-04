import java.util.BitSet;
import java.util.Arrays;

public class a51 {
    public static void main(String[] args) {
        // Step 1: Initialize the key array with the string "THEKEY12"
        String keyString = "THEKEY12";
        byte[] keyBytes = keyString.getBytes();

        // Convert byte[] to Byte[] (autoboxing)
        Byte[] key = new Byte[keyBytes.length];
        for (int i = 0; i < keyBytes.length; i++) {
            key[i] = keyBytes[i];
        }

        // Step 2: Create BitSet registers
        BitSet reg_x = new BitSet(19);
        BitSet reg_y = new BitSet(22);
        BitSet reg_z = new BitSet(23);

        // Step 3: Fill the BitSet registers with the key values
        for (int i = 0; i < key.length; i++) {
            // Convert each byte to individual bits and set in reg_x, reg_y, and reg_z
            for (int bitIndex = 0; bitIndex < 8; bitIndex++) {
                boolean bitValue = (key[i] >> bitIndex & 1) == 1;

                if (i * 8 + bitIndex < 19) {
                    reg_x.set(i * 8 + bitIndex, bitValue);
                }

                if (i * 8 + bitIndex < 22) {
                    reg_y.set(i * 8 + bitIndex, bitValue);
                }

                if (i * 8 + bitIndex < 23) {
                    reg_z.set(i * 8 + bitIndex, bitValue);
                }
            }
        }

        // Print the key array
        System.out.println("Key: " + Arrays.toString(key));

        // Print the BitSet registers
        System.out.println("reg_x: " + reg_x);
        System.out.println("reg_y: " + reg_y);
        System.out.println("reg_z: " + reg_z);
    }
}