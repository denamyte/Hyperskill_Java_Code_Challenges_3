import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final LocalDate date = LocalDate.parse(scanner.nextLine());
            Stream.of(date.getDayOfYear(), " ", date.getDayOfMonth()).forEach(System.out::print);
        }
    }
}