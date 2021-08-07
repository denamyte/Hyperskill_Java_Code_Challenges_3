import java.util.Map;
import java.util.Scanner;


class CheckTheEssay {
    static final Map<String, String> REPLACEMENTS = Map.of(
            "Franse", "France",
            "Eifel tower", "Eiffel Tower",
            "19th", "XIXth",
            "20th", "XXth",
            "21st", "XXIst");

    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        for (Map.Entry<String, String> e: REPLACEMENTS.entrySet()) {
            text = text.replaceAll(e.getKey(), e.getValue());
        }
        System.out.println(text);
    }
}