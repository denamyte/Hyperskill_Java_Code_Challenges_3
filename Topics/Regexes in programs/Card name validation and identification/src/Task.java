import java.util.Scanner;

// write your answer here
public class Task {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String numbers = scn.nextLine();
        String card = numbers.replaceAll("\\s", "");
        String visaRegex = "^4\\d{15}$";  // put your code here
        String americanExpressRegex = "^3[47]\\d{13}$";  // put your code here

        if (card.matches(visaRegex)) {
            System.out.println("Visa");
        } else if (isMasterCard(card)) {
            System.out.println("MasterCard");
        } else if (card.matches(americanExpressRegex)) {
            System.out.println("AmericanExpress");
        } else {
            System.out.println("Card number does not exist");
        }
    }

    private static boolean isMasterCard(String cardNumber) {
        return cardNumber.matches("^\\d{16}$") &&
                (cardNumber.matches("^5[1-5].*") || is2221to2720(cardNumber));
    }

    private static boolean is2221to2720(String cardNumber) {
        int start = Integer.parseInt(cardNumber.substring(0, 4));
        return start >= 2221 && start <= 2720;
    }

}

