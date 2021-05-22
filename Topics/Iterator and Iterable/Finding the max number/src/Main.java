import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static int findMaxByIterator(Iterator<Integer> iterator) {
        final Iterable<Integer> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), false)
                .max(Comparator.comparingInt(i -> i)).orElse(0);
    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findMaxByIterator(list.iterator()));
    }
}