import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        final int[] parents = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        final int[] heights = new int[parents.length];
        Arrays.fill(heights, -1);

        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = getHeight(i, parents, heights);
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        System.out.println(1 + maxHeight);
    }

    public static int getHeight(int index, int[] parents, int[] heights) {
        if (parents[index] == -1) {
            return heights[index] = 0;
        }
        if (heights[index] > -1) {
            return heights[index];
        }
        return heights[index] = 1 + getHeight(parents[index], parents, heights);
    }
}
