public class euclean {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please enter two numbers.");
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println("The greatest common divisor of " + a + " and " + b + " is " + gcd(a, b));
        }
    }
}
