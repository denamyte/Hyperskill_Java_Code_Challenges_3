import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final LocalDateTime dateTime = LocalDateTime.parse(new Scanner(System.in).nextLine());
        final long amount = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0)
                .until(dateTime, ChronoUnit.HOURS);
        System.out.println(amount);
    }
}