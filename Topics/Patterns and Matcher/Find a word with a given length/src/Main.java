import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Both solutions work
            String regex = String.format(".*(^|\\W)[a-zA-Z]{%d}($|\\W).*", Integer.parseInt(scanner.nextLine()));
//            String regex = String.format(".*(^|[^a-zA-Z])[a-zA-Z]{%d}($|[^a-zA-Z]).*",
//                  Integer.parseInt(scanner.nextLine()));
            String line = scanner.nextLine();
            System.out.println(line.matches(regex) ? "YES" : "NO");
        }
    }
}