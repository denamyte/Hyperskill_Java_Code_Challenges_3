import java.util.Scanner;

public class Main {

    static final int A = 53;
    static final long M = 1_000_000_009;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String s = scanner.nextLine();
            int count = scanner.nextInt();

            final long[] hashes = calcPrefixHashes(s);

            int equalsCounter = 0;
            while (count-- > 0) {
                long modMult = 1;
                final int[][] ranges = sortRangeSet(inputRangeSet(scanner));
                modMult = advanceMultiplier(modMult, ranges[0][0]);
                final long hash1 = calcRangeHash(hashes, ranges[0], modMult);
                modMult = advanceMultiplier(modMult, ranges[1][0] - ranges[0][0]);
                final long hash2 = calcRangeHash(hashes, ranges[1], modMult);
                if (hash1 == hash2) {
                    equalsCounter++;
                }
            }

            System.out.println(equalsCounter);
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

    private static long[] calcPrefixHashes(String s) {
        long[] hashes = new long[s.length()];
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < s.length(); i++) {
//            hash += charToLong(s.charAt(i)) * pow;
            hash += s.charAt(i) * pow;
            hash %= M;
            hashes[i] = hash;

            pow = pow * A % M;
        }
        return hashes;
    }

    private static long calcRangeHash(long[] hashes, int[] range, long modMult) {
        final long hash = (hashes[range[1] - 1] - (range[0] == 0 ? 0 : hashes[range[0] - 1]) + M) % M;
        return hash * modMult % M;
    }

    private static long advanceMultiplier(long multiplier, int count) {
        long m = multiplier;
        for (int i = 0; i < count; i++) {
            m = m * A % M;
        }
        return m;
    }

    private static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

}