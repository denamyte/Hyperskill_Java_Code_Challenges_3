import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final LocalDate startDate = LocalDate.parse(scanner.nextLine());
            final int days = scanner.nextInt();

            Stream.iterate(startDate,
                           date -> date.getYear() == startDate.getYear(),
                           date -> date.plusDays(days)
                    )
                    .forEach(System.out::println);
        }
    }
}