import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            MinHeap heap = new MinHeap(n);
            while (n-- > 0) {
                heap.insert(scanner.nextInt());
            }
            heap.valueToCountMap.values().forEach(i -> System.out.printf("%d ", i));
        }
    }
}

class MinHeap {
    private final int[] heap;
    private int size;
    public Map<Integer, Integer> valueToCountMap = new TreeMap<>();

    public MinHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private void countSwaps(int... indices) {
        Arrays.stream(indices).forEach(i -> valueToCountMap.computeIfPresent(heap[i], (k, v) -> v + 1));
    }

    private void swap(int fpos, int spos) {
        countSwaps(fpos, spos);
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void insert(int element) {
        valueToCountMap.put(element, 0);

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }
}