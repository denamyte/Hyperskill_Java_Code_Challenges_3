import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
//            String regex = "^(0($|[.,]0$)|[+-]?0[.,]\\d*[1-9]$)|^[+-]?[1-9]\\d*($|[.,](0$|\\d*[1-9]$))";
//            or
            String regex = "^[+-]?(0|[1-9]\\d*)($|[.,](0$|\\d*[1-9]$))";

            String number = scanner.nextLine();

            System.out.println(number.matches(regex) ? "YES" : "NO");
        }
    }
}