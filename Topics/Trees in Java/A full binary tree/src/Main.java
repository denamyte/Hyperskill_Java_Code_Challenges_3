import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // For a binary tree to be a full one, every its parent node should appear twice or not appear at all;
        // The leaves don't matter
        Scanner scanner = new Scanner(System.in);
        final int pairsCount = scanner.nextInt();
        final int[] parents = IntStream.generate(() -> {
            int next = scanner.nextInt();
            scanner.nextLine();
            return next;
        }).limit(pairsCount).toArray();
        final long distParentsCount = Arrays.stream(parents).distinct().count();
        System.out.println(distParentsCount * 2 == parents.length ? "yes" : "no");
    }
}