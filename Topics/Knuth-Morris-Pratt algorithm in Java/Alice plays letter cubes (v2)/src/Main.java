import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final String s = new Scanner(System.in).nextLine();

        System.out.println(IntStream.rangeClosed(1, s.length())
                .map(i -> i - prefixFunctionMax(s, i))
                .reduce(1, Integer::sum));
    }

    public static int prefixFunctionMax(String str, int length) {
        int shift = str.length() - length;
        int[] prefixFunc = new int[length];

        for (int i = 1; i < length; i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i + shift) != str.charAt(j + shift)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i + shift) == str.charAt(j + shift)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }
        return Arrays.stream(prefixFunc).max().orElseThrow();
    }

}