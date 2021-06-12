import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String part = scanner.nextLine();
            String line = scanner.nextLine();

            boolean matches = test("\\b" + part, line) || test(part + "\\b", line);
            System.out.println(matches ? "YES" : "NO");
        }
    }

    private static boolean test(String regex, String text) {
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text).find();
//        or
//        return Pattern.matches("(?i).*" + regex + ".*", text);
    }
}