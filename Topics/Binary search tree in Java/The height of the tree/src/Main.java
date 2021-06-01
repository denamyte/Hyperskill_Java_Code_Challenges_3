import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BST bst = new BST();

            IntStream.generate(scanner::nextInt).limit(scanner.nextInt())
                    .forEach(value -> bst.insert(value, value));

            System.out.println(bst.depth());
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

    private int optionalDepth(Node t, int curDepth) {
        return t == null ? curDepth : depth(t, curDepth + 1);
    }

    private int depth(Node t, int curDepth) {
        return Math.max(optionalDepth(t.left, curDepth), optionalDepth(t.right, curDepth));
    }

    public int depth() {
        return root == null ? 0 : depth(root, 0);
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
