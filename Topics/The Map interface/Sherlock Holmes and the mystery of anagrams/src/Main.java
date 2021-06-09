import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Why should this problem be related to maps?! Idk...
class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> list1 = toSortedList(scanner.nextLine());
            List<Integer> list2 = toSortedList(scanner.nextLine());
            System.out.println(list1.equals(list2) ? "yes" : "no");
        }
    }

    private static List<Integer> toSortedList(String s) {
        return s.toLowerCase().chars().sorted().boxed().collect(Collectors.toList());
    }
}