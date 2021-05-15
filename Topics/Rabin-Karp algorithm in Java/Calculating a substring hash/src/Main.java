import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static final int A = 53;
    static final long M = 1_000_000_009;


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String s = scanner.nextLine();
            final long[] hashes = calcPrefixHashes(s);
            printLongArray(hashes);

            final long[] subHashes = Stream.generate(scanner::nextLine).limit(Integer.parseInt(scanner.nextLine()))
                    .mapToLong(rangeStr -> calcRangeHash(hashes, rangeStr)).toArray();
            printLongArray(subHashes);
        }
    }

    private static long calcRangeHash(long[] hashes, String rawRange) {
        final int[] range = Arrays.stream(rawRange.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return (hashes[range[1] - 1] - (range[0] == 0 ? 0 : hashes[range[0] - 1]) + M) % M;
    }

    private static long[] calcPrefixHashes(String s) {
        long[] hashes = new long[s.length()];
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < s.length(); i++) {
            hash += charToLong(s.charAt(i)) * pow;
            hash %= M;
            hashes[i] = hash;

            pow = pow * A % M;
        }
        return hashes;
    }

    private static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    private static void printLongArray(long[] hashes) {
        System.out.println(Arrays.stream(hashes).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}