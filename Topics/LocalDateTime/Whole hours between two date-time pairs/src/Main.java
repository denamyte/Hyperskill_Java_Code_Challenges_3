import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Math.abs(getDTSeconds(scanner) - getDTSeconds(scanner)) / 3600);
        }
    }

    static long getDTSeconds(Scanner scanner) {
        return Math.abs(LocalDateTime.parse(scanner.nextLine()).toEpochSecond(ZoneOffset.UTC));
    }
}