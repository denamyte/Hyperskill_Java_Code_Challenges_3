import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String upperRegex = ".*[A-Z].*";
        String lowerRegex = ".*[a-z].*";
        String digitRegex = ".*\\d.*";
        try (Scanner scanner = new Scanner(System.in)) {
            String pwd = scanner.nextLine();
            System.out.println(
                    pwd.matches(upperRegex)
                            && pwd.matches(lowerRegex)
                            && pwd.matches(digitRegex)
                            && pwd.length() >= 12
                            ? "YES" : "NO");
        }
    }
}