import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    private static final Map<String, BiConsumer<BST, List<Integer>>> BST_OPS = Map.of(
            "+", (bst, args) -> bst.insert(args.get(0), args.get(1)),
            "-", (bst, args) -> bst.remove(args.get(0)),
            "!", (bst, args) -> bst.changeValue(args.get(0), args.get(1)));

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BST bst = new BST();
            Stream.generate(scanner::nextLine)
                    .limit(Integer.parseInt(scanner.nextLine()))
                    .map(s -> s.split("\\s+"))
                    .forEach(ar -> {
                        List<Integer> intArgs = Arrays.stream(ar)
                                .skip(1)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        BST_OPS.get(ar[0]).accept(bst, intArgs);
                    });
            System.out.println(bst.values().stream().map(String::valueOf).collect(Collectors.joining(" ")));
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

    public void changeValue(int key, int value) {
        Node node = search(key);
        if (node != null) {
            node.value = value;
        }
    }

    private void values(List<Integer> vList, Node t) {
        if (t == null) {
            return;
        }
        values(vList, t.left);
        vList.add(t.value);
        values(vList, t.right);
    }

    public List<Integer> values() {
        List<Integer> vList = new LinkedList<>();
        values(vList, root);
        return vList;
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

    private void replace(Node a, Node b) {
        if (a.parent == null) {
            root = b;
        } else if (a == a.parent.left) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }
        if (b != null) {
            b.parent = a.parent;
        }
    }

    private void remove(Node t, int key) {
        if (t == null) {
            return;
        }
        if (key < t.key) {
            remove(t.left, key);
        } else if (key > t.key) {
            remove(t.right, key);
        } else if (t.left != null && t.right != null) {
            Node m = t.right;
            while (m.left != null) {
                m = m.left;
            }
            t.key = m.key;
            t.value = m.value;
            replace(m, m.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    public void remove(int key) {
        remove(root, key);
    }
}