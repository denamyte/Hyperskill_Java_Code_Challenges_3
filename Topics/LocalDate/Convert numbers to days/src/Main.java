import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = scanner.nextInt();
            IntStream.generate(scanner::nextInt)
                    .limit(3)
                    .mapToObj(day -> LocalDate.ofYearDay(year, day))
                    .forEach(System.out::println);
        }
    }
}