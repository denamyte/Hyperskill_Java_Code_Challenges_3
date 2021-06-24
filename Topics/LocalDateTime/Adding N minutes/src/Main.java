import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LocalDateTime dt = LocalDateTime.parse(scanner.nextLine()).plusMinutes(scanner.nextInt());
            System.out.printf("%d %d %s", dt.getYear(), dt.getDayOfYear(), dt.toLocalTime());
        }
    }
}