import java.util.*;
import java.util.regex.Pattern;

class Date {

    static final Pattern PATTERN = Pattern.compile(
            "^((19|20)\\d{2}[- /.](0?[1-9]|1[012])[- /.](0[1-9]|[12]\\d|3[01])" + "|" +
                    "(0[1-9]|[12]\\d|3[01])[- /.](0?[1-9]|1[012])[- /.](19|20)\\d{2})$");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    PATTERN.matcher(scanner.nextLine()).matches()
                            ? "Yes"
                            : "No"
            );
        }
    }
}
