import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String p = scanner.nextLine();
        final String s = scanner.nextLine();

//        StringBuilder occurrences = new StringBuilder();
//        int cursor = 0;
//        int found;
//        int count = 0;
//        while (cursor < s.length() && (found = s.indexOf(p, cursor)) > -1) {
//            occurrences.append(found).append(" ");
//            count++;
//            cursor = found + p.length();
//        }
//
//        System.out.println(count);
//        if (cursor > 0) {
//            System.out.println(occurrences);
//        }

        final List<Integer> indices = KMPSearch(s, p);
        System.out.println(indices.size());
        indices.forEach(i -> System.out.printf("%d ", i));
    }

    public static int[] prefixFunction(String str) {
        /* 1 */
        int[] prefixFunc = new int[str.length()];

        /* 2 */
        for (int i = 1; i < str.length(); i++) {
            /* 3 */
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            /* 4 */
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            /* 5 */
            prefixFunc[i] = j;
        }

        /* 6 */
        return prefixFunc;
    }

    public static List<Integer> KMPSearch(String text, String pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        int j = 0;
        /* 2 */
        for (int i = 0; i < text.length(); i++) {
            /* 3 */
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            /* 4 */
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            /* 5 */
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
//                j = prefixFunc[j - 1];
                j = 0;
            }
        }
        /* 6 */
        return occurrences;
    }
}