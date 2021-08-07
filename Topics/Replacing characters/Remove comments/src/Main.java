import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        System.out.println(s.replaceAll("/\\*.*?\\*/|\\s*//.*$", ""));
    }
}