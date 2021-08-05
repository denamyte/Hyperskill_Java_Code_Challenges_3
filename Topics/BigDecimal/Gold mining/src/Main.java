import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    scanner.tokens().limit(3)
                            .map(BigDecimal::new)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));
        }
    }
}