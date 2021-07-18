import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);
            LocalDate monday = date.plusDays((8 - date.getDayOfWeek().getValue()) % 7);
            while (date.getMonthValue() == monday.getMonthValue()) {
                System.out.println(monday);
                monday = monday.plusDays(7);
            }
        }
    }
}