import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.parse(new Scanner(System.in).nextLine()).plusHours(11).toLocalDate());
    }
}