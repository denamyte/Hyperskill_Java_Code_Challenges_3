import java.util.*;

public class Main {

    static final int POWER_BASE = 53;
    static final long MODULO_ARG = 1_000_000_000 + 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        System.out.println(findRepeatingSubstring(s, k));
    }

    private static String findRepeatingSubstring(String s, int k) {
        Map<Long, List<Integer>> hashToIndexList = new HashMap<>();

        long hash = hashForEndingSubstring(s, k);
        hashToIndexList.put(hash, new LinkedList<>(List.of(s.length() - k)));

        long pow = 1;
        for (int i = 1; i < k; i++) {
            pow = pow * POWER_BASE % MODULO_ARG;
        }

        for (int startIndex = s.length() - 1 - k; startIndex >= 0; startIndex--) {
            hash = rollHash(hash, pow, s.charAt(startIndex + k), s.charAt(startIndex));

            if (hashToIndexList.containsKey(hash)) {
                final List<Integer> indexes = hashToIndexList.get(hash);
                final String substring = s.substring(startIndex, startIndex + k);

                for (var index : indexes) {
                    if (s.substring(index, index + k).equals(substring)) {
                        return substring;
                    }
                }

                indexes.add(startIndex);
            } else {
                hashToIndexList.put(hash, new LinkedList<>(List.of(startIndex)));
            }
        }
        return "does not contain";
    }

    private static long hashForEndingSubstring(String s, int subLength) {
        long hash = 0;
        long pow = 1;

        for (int i = s.length() - subLength; i < s.length(); i++) {
            hash += charToLong(s.charAt(i)) * pow;
            hash %= MODULO_ARG;

            pow = pow * POWER_BASE % MODULO_ARG;
        }
        return hash;
    }

    private static long rollHash(long hash, long pow, char removeChar, char nextChar) {
        long hash2 = (hash - charToLong(removeChar) * pow % MODULO_ARG + MODULO_ARG) * POWER_BASE % MODULO_ARG;
        return (hash2 + charToLong(nextChar)) % MODULO_ARG;
    }

    private static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

}