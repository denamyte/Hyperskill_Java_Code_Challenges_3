import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            MinHeap heap = new MinHeap(values);
            List<Integer> sorted = new LinkedList<>();
            while (n-- > 0) {
                printStream(heap.getHeapStream());
                sorted.add(heap.extractMin());
            }
            printStream(sorted.stream());
        }
    }

    private static void printStream(Stream<Integer> stream) {
        System.out.println(stream.map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int[] unsortedValues) {
        size = unsortedValues.length;
        heap = new int[size + 1];
        heap[0] = Integer.MIN_VALUE;
        System.arraycopy(unsortedValues, 0, heap, 1, size);
        minHeap();
    }

    public Stream<Integer> getHeapStream() {
        return Arrays.stream(heap).skip(1).limit(size).boxed();
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (2 * pos == size) {
            if (heap[pos] > heap[2 * pos]) {
                swap(pos, 2 * pos);
                minHeapify(2 * pos);
            }
            return;
        }

        if (2 * pos <= size) {
            if (heap[pos] > heap[2 * pos] || heap[pos] > heap[2 * pos + 1]) {
                // Sorry, checker, I can't combine these ifs
                if (heap[2 * pos] < heap[2 * pos + 1]) {
                    swap(pos, 2 * pos);
                    minHeapify(2 * pos);
                } else {
                    swap(pos, 2 * pos + 1);
                    minHeapify(2 * pos + 1);
                }
            }
        }
    }

    public final void minHeap() {
        for (int pos = size / 2; pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }
}