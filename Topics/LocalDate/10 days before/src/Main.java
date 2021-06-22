import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(LocalDate.parse(scanner.nextLine()).minusDays(10));
        }
    }
}