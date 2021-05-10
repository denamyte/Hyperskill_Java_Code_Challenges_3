import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static final int a = 53;
    static final long m = 1_000_000_000 + 9;

    public static void main(String[] args) {
        final String s = inputString();
        Set<Long> hashes = new HashSet<>();
        long pow = 1;

        for (int subLength = 1; subLength < s.length(); subLength++) {
            long hash = hashForEndingSubstring(s, subLength);
            hashes.add(hash);
            for (int startIndex = s.length() - 1 - subLength; startIndex >= 0; startIndex--) {
                hash = rollHash(hash, pow, s.charAt(startIndex + subLength), s.charAt(startIndex));
                hashes.add(hash);
            }

            pow = pow * a % m;
        }
        int count = hashes.size() + 2;

        System.out.println(count);
    }

    private static String inputString() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    private static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    /**
     * @param s the full string
     * @param subLength the length of the substring which ending coincides with the string ending
     * @return the hash for the substring given
     */
    private static long hashForEndingSubstring(String s, int subLength) {
        long hash = 0;
        long pow = 1;

        for (int i = s.length() - subLength; i < s.length(); i++) {
            hash += charToLong(s.charAt(i)) * pow;
            hash %= m;

            pow = pow * a % m;
        }
        return hash;
    }

    private static long rollHash(long hash, long pow, char removeChar, char nextChar) {
        hash = (hash - charToLong(removeChar) * pow % m + m) * a % m;
        return (hash + charToLong(nextChar)) % m;
    }
}