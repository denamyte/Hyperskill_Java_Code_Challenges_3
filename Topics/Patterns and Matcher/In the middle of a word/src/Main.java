import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String regex = String.format("(?i).*\\B%s\\B.*", scanner.nextLine());
            String line = scanner.nextLine();
            System.out.println(line.matches(regex) ? "YES" : "NO");
        }
    }
}