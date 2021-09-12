import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {  // Testing repeated pressing "Check" button and upload changed solution
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextBigDecimal()
                    .setScale(scanner.nextInt(), RoundingMode.HALF_DOWN));
        }
    }   
}