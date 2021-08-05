import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BigDecimal startingAmount = scanner.nextBigDecimal();
            BigDecimal interestRate = scanner.nextBigDecimal();
            int numberOfYears = scanner.nextInt();

            BigDecimal finalAmount = BigDecimal.ONE.add(interestRate.multiply(BigDecimal.valueOf(0.01)))
                    .pow(numberOfYears).multiply(startingAmount)
                    .setScale(2, RoundingMode.CEILING);

            System.out.printf("Amount of money in the account: %s", finalAmount);
        }
    }
}