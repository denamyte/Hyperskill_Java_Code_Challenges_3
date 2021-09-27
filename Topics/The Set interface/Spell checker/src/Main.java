import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    private static Set<String> knownWords;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            knownWords = getKnownWords(scanner);
            collectUnknownWords(scanner)
                    .forEach(System.out::println);
        }
    }

    private static Set<String> getKnownWords(Scanner scanner) {
        return startStream(scanner)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    private static Set<String> collectUnknownWords(Scanner scanner) {
        return startStream(scanner)
                .flatMap(Main::selectUnknownWords)
                .collect(Collectors.toSet());
    }

    private static Stream<String> startStream(Scanner scanner) {
        return Stream.generate(scanner::nextLine)
                .limit(Integer.parseInt(scanner.nextLine()));
    }

    private static Stream<String> selectUnknownWords(String line) {
        return Arrays.stream(line.split(" "))
                .filter(Predicate.not(Main::contains));
    }

    private static boolean contains(String word) {
        return knownWords.contains(word.toLowerCase());
    }
}