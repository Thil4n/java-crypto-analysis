import java.math.BigInteger;

public class totient {
    public static boolean isCoPrime(BigInteger a, BigInteger b) {

        BigInteger gcd = a.gcd(b);
        return gcd.compareTo(BigInteger.ONE) == 0;
    }

    public static int totient(BigInteger n) {
        int count = 0;
        for (int i = 1; i < n.intValue(); i++) {
            if (isCoPrime(new BigInteger(Integer.toString(i)), n)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter a number.");
        } else {
            BigInteger num = new BigInteger(args[0]);

            System.out.println("The totient of " + num + " is " + totient(num));

        }
    }

}
