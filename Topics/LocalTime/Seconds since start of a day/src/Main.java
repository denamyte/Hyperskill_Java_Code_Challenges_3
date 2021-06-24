import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(LocalTime.ofSecondOfDay(scanner.nextInt()));
        }
    }
}