import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int power = scanner.nextInt();
            int scale = scanner.nextInt();
            BigDecimal number = new BigDecimal(scanner.next())
                    .setScale(scale, RoundingMode.FLOOR)
                    .pow(power);
            System.out.println(number);
        }
    }
}