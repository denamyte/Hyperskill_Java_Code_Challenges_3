import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()));
        }
    }
}