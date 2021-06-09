import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var w1 = readWord(scanner);
        var w2 = readWord(scanner);
        long w1Size = w1.stream().filter(value -> !w2.remove(value)).count();
        System.out.println(w1Size + w2.size());
    }

    static List<Character> readWord(Scanner scanner) {
        return scanner.nextLine().toLowerCase().chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }
}