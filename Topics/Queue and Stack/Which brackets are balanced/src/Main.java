import java.util.*;

class Main {

    private static final Map<Character, BracketPair> BRACKET_PAIRS = Map.of(
            '{', new BracketPair('{', '}'),
            '(', new BracketPair('(', ')'),
            '[', new BracketPair('[', ']')
    );

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Deque<BracketPair> bracketPairStack = new LinkedList<>();
            boolean processed = scanner.nextLine().chars().allMatch(i -> processBracket(bracketPairStack, (char) i));
            System.out.println(processed && bracketPairStack.isEmpty());
        }
    }

    private static boolean processBracket(Deque<BracketPair> stack, char bracket) {
        BracketPair pair = BRACKET_PAIRS.get(bracket);
        if (pair == null) {
            pair = stack.peekLast();
            if (pair != null && pair.close == bracket) {
                stack.pollLast();
                return true;
            }
            return false;
        } else {
            return stack.offer(pair);
        }
    }
}

class BracketPair {
    char open;
    char close;

    public BracketPair(char open, char close) {
        this.open = open;
        this.close = close;
    }

    @Override
    public String toString() {
        return open + " " + close;
    }
}