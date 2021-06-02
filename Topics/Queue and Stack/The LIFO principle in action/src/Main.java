import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stream.generate(scanner::next).limit(scanner.nextInt())
                .collect(ArrayDeque::new, Deque::addFirst, (o1, o2) -> { })
                .forEach(System.out::println);
    }
}