import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> parents = new LinkedList<>();
        List<Integer> leaves = new LinkedList<>();

        int count = scanner.nextInt();
        while (count-- > 0) {
            parents.add(scanner.nextInt());
            leaves.add(scanner.nextInt());
        }
        scanner.close();

        List<String> filteredLeaves = leaves.stream()
                .filter(Predicate.not(parents::contains))
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(filteredLeaves.size());
        System.out.println(String.join(" ", filteredLeaves));
    }
}