import java.util.*;

class Main {

    // Keeps max values. Every max value is written only once
    private static final Deque<Integer> maxStack = new ArrayDeque<>();

    // Keeps counts of how many times every max value is repeated in the maxStack
    private static final Deque<Integer> repeatStack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            final String[] cmd = scanner.nextLine().split("\\s+");
            switch (cmd[0]) {
                case "push":
                    push(Integer.parseInt(cmd[1]));
                    break;
                case "max": System.out.println(maxStack.peekLast());
                    break;
                default: pop();
                    break;
            }
        }
    }

    static void push(int value) {
        if (repeatStack.size() > 0 && value <= maxStack.peekLast()) {
            repeatStack.offerLast(repeatStack.pollLast() + 1);
        } else {
            maxStack.offerLast(value);
            repeatStack.offerLast(1);
        }
    }

    static void pop() {
        final int repeatCount = repeatStack.pollLast();
        if (repeatCount == 1) {
            maxStack.pollLast();
        } else {
            repeatStack.offerLast(repeatCount - 1);
        }
    }
}