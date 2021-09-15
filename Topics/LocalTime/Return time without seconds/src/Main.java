import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    scanner.useDelimiter(Pattern.compile("[:\n]"))
                            .tokens()
                            .limit(2)
                            .collect(Collectors.joining(":")));
        }
    }
}