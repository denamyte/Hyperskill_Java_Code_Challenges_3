import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BigDecimal bd = scanner.tokens().limit(3)
                    .map(BigDecimal::new)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println(bd.divide(BigDecimal.valueOf(3), 0, RoundingMode.DOWN));
        }
    }
}