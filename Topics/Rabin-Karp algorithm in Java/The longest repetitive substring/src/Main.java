import java.util.*;

public class Main {

    static final int POW = 49157;
    static final long MOD = 10_000_000_000_009L;

    public static void main(String[] args) {
        String s = "";
        try (Scanner scanner = new Scanner(System.in)) {
            s = scanner.nextLine();
        }
        System.out.println(longestRepetitiveSubstringLength(s));
    }

    private static int longestRepetitiveSubstringLength(String s) {
        int lo = 1;
        int hi = s.length() - 1;

        // Binary search loop
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasRepetitiveSubstringOfLength(s, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo == 0 ? 0 : lo - 1;
    }

    private static boolean hasRepetitiveSubstringOfLength(String s, int k) {
        Set<Long> hashes = new HashSet<>();

        long hash = 0;
        long pow = 1;

        // The hash for the substring at the end of the string
        for (int i = s.length() - k; i < s.length(); i++) {
            if (i > s.length() - k) {
                pow = pow * POW % MOD;
            }
            hash += s.charAt(i) * pow;
            hash %= MOD;
        }
        hashes.add(hash);

        for (int i = s.length() - 1 - k; i >= 0; i--) {
            hash = rollHash(hash, pow, s.charAt(i + k), s.charAt(i));

            if (hashes.contains(hash)) {
                return true;
            }
            hashes.add(hash);
        }

        return false;
    }

    private static long rollHash(long hash, long pow, char removeChar, char nextChar) {
        long hash2 = (hash - removeChar * pow % MOD + MOD) * POW % MOD;
        return (hash2 + nextChar) % MOD;
    }

}