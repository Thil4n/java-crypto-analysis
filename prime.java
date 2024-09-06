public class prime {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please enter a number.");

        } else {
            int num = Integer.parseInt(args[0]);
            if (isPrime(num)) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }

    }
}
