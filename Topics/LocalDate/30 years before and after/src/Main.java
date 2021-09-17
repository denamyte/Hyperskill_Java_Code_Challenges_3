import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final LocalDate date = LocalDate.parse(scanner.nextLine());
            IntStream.of(-30, 30).mapToObj(i -> date.withYear(date.getYear() + i))
                    .forEach(System.out::println);
        }
    }
}