import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        String s = "";
        try (Scanner scanner = new Scanner(System.in)) {
            s = scanner.nextLine();
        }
        Pattern pattern = Pattern.compile("\\w*program\\w*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.printf("%d %s%n", matcher.start(), matcher.group());
        }
    }
}