import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int sec1 = LocalTime.parse(scanner.nextLine()).toSecondOfDay();
            int sec2 = LocalTime.parse(scanner.nextLine()).toSecondOfDay();
            System.out.println(Math.abs(sec2 - sec1));
        }
    }
}