import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keys = scanner.nextLine();
        String values = scanner.nextLine();
        String strToEncode = scanner.nextLine();
        String strToDecode = scanner.nextLine();

        final Map<Character, Character> encodeMap = getMapFromKeyValueStrings(keys, values);
        final Map<Character, Character> decodeMap = getMapFromKeyValueStrings(values, keys);

        System.out.println(substituteChars(strToEncode, encodeMap));
        System.out.println(substituteChars(strToDecode, decodeMap));
    }

    static Map<Character, Character> getMapFromKeyValueStrings(String keys, String values) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }
        return map;
    }

    static String substituteChars(String str, Map<Character, Character> substitutionMap) {
        return str.chars()
                .mapToObj(i -> substitutionMap.get((char) i))
                .collect(StringBuilder::new, StringBuilder::append, (sb1, sb2) -> { }).toString();
    }
}