import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String s = scanner.nextLine();
        scanner.nextLine();

        final String result = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(p -> p + s)
                .map(str -> "" + (str.length() - getMaxFromPF(str)))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static int getMaxFromPF(String str) {
        return Arrays.stream(prefixFunction(str)).max().orElseThrow();
    }


    public static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }
        return prefixFunc;
    }
}