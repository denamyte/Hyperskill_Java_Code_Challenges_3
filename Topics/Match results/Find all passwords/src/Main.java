import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile("password[ :]+(\\w+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            if (printPasswords(matcher) == 0) {
                System.out.println("No passwords found.");
            }
        }
    }

    private static int printPasswords(Matcher matcher) {
        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            count++;
        }
        return count;
    }
}