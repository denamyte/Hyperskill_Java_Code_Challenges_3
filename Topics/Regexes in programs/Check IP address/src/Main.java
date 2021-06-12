import java.util.*;

public class Main {
    public static void main(String[] args) {
        String ipRegex = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextLine().matches(ipRegex) ? "YES" : "NO");
        }
    }
}