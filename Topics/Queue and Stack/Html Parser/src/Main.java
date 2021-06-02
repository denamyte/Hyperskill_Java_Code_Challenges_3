import java.util.*;

class Main {
    public static void main(String[] args) {
        new ShallowParser(new Scanner(System.in).nextLine());
    }
}

class ShallowParser {

    private final String text;
    private final Deque<Integer> beginIndexStack = new LinkedList<>();
    private int cursor;

    public ShallowParser(String text) {
        this.text = text;
        parse();
    }

    private void parse() {
        while (cursor < text.length()) {
            moveCursorAfterChar('<');
            if (text.charAt(cursor) == '/') {
                // The previous tag ends, its content should be printed
                cursor += 1;
                Optional.ofNullable(beginIndexStack.pollLast()).ifPresent(i -> {
                    System.out.println(text.substring(i, cursor - 2));
                    moveCursorAfterChar('>');
                });
                continue;
            }
            // A new tag comes, find the index where its content begins
            moveCursorAfterChar('>');
            beginIndexStack.offerLast(cursor);
        }
    }

    private void moveCursorAfterChar(char c) {
        cursor = 1 + text.indexOf(c, cursor);
    }
}
