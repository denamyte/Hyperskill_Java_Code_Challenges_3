import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);
            System.out.printf("%s %s%n", date, date.plusDays(date.lengthOfMonth() - 1));
        }
    }
}