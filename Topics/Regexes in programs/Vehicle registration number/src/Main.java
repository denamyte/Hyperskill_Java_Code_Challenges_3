import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String regNum = scanner.nextLine(); // a valid or invalid registration number

            System.out.println(regNum.matches("[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}"));
        }
    }
}