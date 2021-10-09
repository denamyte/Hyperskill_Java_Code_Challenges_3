import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;

public class Main {

    static final List<Integer> NUMBERS = List.of(2, 0, 1, 7);

    public static void main(String[] args) {
        final Queue<Integer> queue = NUMBERS.stream()
                .collect(Collector.of(ArrayDeque<Integer>::new, Queue::offer, (q1, q2) -> q1));
        System.out.println(queue);
    }
}