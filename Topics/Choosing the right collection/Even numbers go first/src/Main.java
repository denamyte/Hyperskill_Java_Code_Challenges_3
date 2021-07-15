import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

class Main {
    private static final BiConsumer<Deque<Integer>, Integer> ACCUMULATOR = (list, i) -> {
        if ((i & 1) == 1) {
            list.addLast(i);
        } else {
            list.addFirst(i);
        }
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            IntStream.generate(scanner::nextInt).limit(scanner.nextInt())
                    .boxed().collect(LinkedList::new, ACCUMULATOR, (l1, l2) -> { })
                    .forEach(System.out::println);

        }
    }
}