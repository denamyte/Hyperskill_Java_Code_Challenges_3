import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        // Both  \<.+?>\  and  \<[^<]+>\  work
        System.out.println(s.replaceAll("<.+?>", ""));
    }
}