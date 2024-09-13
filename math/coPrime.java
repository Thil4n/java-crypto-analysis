import java.math.BigInteger;

public class coPrime {

    public static boolean isCoPrime(BigInteger a, BigInteger b) {

        BigInteger gcd = a.gcd(b);
        return gcd.compareTo(BigInteger.ONE) == 0;
    }

    public static void main(String[] args) {

        if (args.length != 2) {

            System.out.println("Please enter two numbers.");

        } else {
            BigInteger a = new BigInteger(args[0]);
            BigInteger b = new BigInteger(args[1]);

            System.out.println(a + " and " + b + " are ");

            if (isCoPrime(a, b)) {
                System.out.println("co-prime numbers.");
            } else {
                System.out.println("not co-prime numbers.");
            }
        }
    }

}
