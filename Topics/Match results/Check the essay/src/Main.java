import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Pattern pattern = Pattern.compile("the\\s+key\\s+is\\s+([\\w&&[^aeiou]]+|[?!#aeiou]+)\\s+",
                                              Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }
    }
}