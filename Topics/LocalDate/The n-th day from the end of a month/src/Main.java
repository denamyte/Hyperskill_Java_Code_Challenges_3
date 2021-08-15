import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1)
                                       .plusMonths(1).minusDays(scanner.nextInt()));
        }
    }
}