import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int size = 0;
            while (n-- > 0) {
                final String cmd = scanner.nextLine();
                if ('+' == cmd.charAt(0)) {
                    size++;
                } else if ("-".equals(cmd)) {
                    size--;
                } else {
                    System.out.println((int) (Math.log(size) / Math.log(2)));
                }
            }
        }
    }
}