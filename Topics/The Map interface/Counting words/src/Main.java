import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class MapUtils {

    public static SortedMap<String, Long> wordCount(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    }

    public static void printMap(Map<String, Long> map) {
        map.forEach((k, v) -> System.out.printf("%s : %d%n", k, v));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}