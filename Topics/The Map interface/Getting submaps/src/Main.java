import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int size = scanner.nextInt();
        IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toMap(i -> scanner.nextInt(),
                                          i -> scanner.next(),
                                          (s, s1) -> s,
                                          TreeMap::new))
                .entrySet().stream()
                .dropWhile(en -> en.getKey() < from)
                .takeWhile(en -> en.getKey() <= to)
                .forEach(en -> System.out.printf("%d %s%n", en.getKey(), en.getValue()));
    }
}