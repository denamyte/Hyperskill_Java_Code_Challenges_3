import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var words = countWordsInLine(scanner);
        var note = countWordsInLine(scanner);
        System.out.println(enoughWordsForTheNote(words, note) ? "You get money" : "You are busted");
    }

    static Map<String, Long> countWordsInLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    static boolean enoughWordsForTheNote(Map<String, Long> words, Map<String, Long> note) {
        for (var e : note.entrySet()) {
            final Long count = words.get(e.getKey());
            if (count == null || count < e.getValue()) {
                return false;
            }
        }
        return true;
    }
}