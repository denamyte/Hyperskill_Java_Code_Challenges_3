import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

class Main {

    private static final Map<String, BiConsumer<BST, Integer>> BST_OPS = Map.of(
            "+", (bst, arg) -> bst.insert(arg, arg),
            "?", Main::printDepth
    );

    private static void printDepth(BST bst, int key) {
        int depth = bst.depth(key);
        System.out.println(depth >= 0 ? "" + depth : "no");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BST bst = new BST();
            Stream.generate(scanner::nextLine)
                    .limit(Integer.parseInt(scanner.nextLine()))
                    .map(s -> s.split("\\s+"))
                    .forEach(ar -> BST_OPS.get(ar[0]).accept(bst, Integer.parseInt(ar[1])));
        }
    }
}

class BST {

    private Node root;

    static class Node {
        int key;
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int key, int value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    public int depth(int key) {
        Node t = search(key);
        if (t == null) {
            return -1;
        }
        int depth = 0;
        while (t.parent != null) {
            t = t.parent;
            depth++;
        }
        return depth;
    }

    private Node search(Node t, int key) {
        if (t == null || t.key == key) {
            return t;
        }
        if (key < t.key) {
            return search(t.left, key);
        } else {
            return search(t.right, key);
        }
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            return new Node(key, value, p);
        }
        if (key < t.key) {
            t.left = insert(t.left, t, key, value);
        } else {
            t.right = insert(t.right, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

}