public class AES {

    byte[] key_array = new byte[] { 'T', 'H', 'E', 'K', 'E', 'Y', };

    public static void main(String[] args) {
        AES aes = new AES();
        aes.encrypt();
    }

    public void encrypt() {
        String plain_text = "Hello, World!";
        byte[] plain_text_bytes = plain_text.getBytes();
        byte[] cipher_text_bytes = new byte[plain_text_bytes.length];
        for (int i = 0; i < plain_text_bytes.length; i++) {
            cipher_text_bytes[i] = (byte) (plain_text_bytes[i] ^ key_array[i % key_array.length]);
        }
        String cipher_text = new String(cipher_text_bytes);
        System.out.println(cipher_text);
    }

    public void decrypt() {
        String cipher_text = "Hello, World!";
        byte[] cipher_text_bytes = cipher_text.getBytes();
        byte[] plain_text_bytes = new byte[cipher_text_bytes.length];
        for (int i = 0; i < cipher_text_bytes.length; i++) {
            plain_text_bytes[i] = (byte) (cipher_text_bytes[i] ^ key_array[i % key_array.length]);
        }
        String plain_text = new String(plain_text_bytes);
        System.out.println(plain_text);
    }
}
