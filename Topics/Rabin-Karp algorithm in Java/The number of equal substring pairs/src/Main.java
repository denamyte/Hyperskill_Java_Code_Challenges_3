import java.util.*;

public class Main {

    static final int A = 53;
    static final long M = 1_000_000_009;
    static long[] powerCache;
    static long[] hashes;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String s = scanner.nextLine();
            int count = scanner.nextInt();

            calcPrefixHashesAndPowers(s);

            int equalsCounter = 0;
            while (count-- > 0) {
                final int[][] ranges = sortRangeSet(inputRangeSet(scanner));
                final long hash1 = calcRangeHash(hashes, ranges[0], powerCache[ranges[1][0] - ranges[0][0]]);
                final long hash2 = calcRangeHash(hashes, ranges[1], 1);
                if (hash1 == hash2) {
                    equalsCounter++;
                }
            }

            System.out.println(equalsCounter);
        }
    }

    private static void calcPrefixHashesAndPowers(String s) {
        hashes = new long[s.length()];
        powerCache = new long[s.length()];
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < s.length(); i++) {
            powerCache[i] = pow;
            hash += s.charAt(i) * pow;
            hash %= M;
            hashes[i] = hash;

            pow = pow * A % M;
        }
    }

    private static int[][] sortRangeSet(int[][] rangeSet) {
        return rangeSet[0][0] <= rangeSet[1][0]
                ? rangeSet
                : new int[][]{rangeSet[1], rangeSet[0]};
    }

    private static int[][] inputRangeSet(Scanner scanner) {
        return new int[][]{inputRange(scanner), inputRange(scanner)};
    }

    private static int[] inputRange(Scanner scanner) {
        return new int[]{scanner.nextInt(), scanner.nextInt()};
    }

    private static long calcRangeHash(long[] hashes, int[] range, long powDiff) {
        final long hash = (hashes[range[1] - 1] - (range[0] == 0 ? 0 : hashes[range[0] - 1]) + M) % M;
        return hash * powDiff % M;
    }

}