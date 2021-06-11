import java.util.Scanner;
import java.util.stream.LongStream;

class PrimeNumbers {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    private static boolean isPrime(long number) {
//        return 1 == LongStream.rangeClosed(2, number).filter(value -> number % value == 0).count();
//        or
        return LongStream.range(2, number).noneMatch(value -> number % value == 0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();

        int n = Integer.parseInt(line);

        System.out.println(isPrime(n) ? "True" : "False");
    }
}