import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        System.out.println(text.trim().replaceAll("\\s{2,}", " "));
    }
}