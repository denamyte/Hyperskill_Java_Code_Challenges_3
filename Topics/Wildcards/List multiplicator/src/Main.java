import java.util.ArrayList;
import java.util.List;

/**
 * Class to modify
 */
class ListMultiplicator {

    /**
     * Repeats original list content provided number of times
     *
     * @param list list to repeat
     * @param n    times to repeat, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        multiplyGen(list, n);
    }

    private static <T> void multiplyGen(List<T> list, int n) {
        List<T> temp = new ArrayList<>(list);
        list.clear();
        while (n-- > 0) {
            list.addAll(temp);
        }
    }
}

//public class Main {
//    public static void main(String[] args) {
//        List<String> stringList = new ArrayList<>(List.of("a", "b", "c"));
//
//        ListMultiplicator.multiply(stringList, 1);
//        System.out.println(stringList);
//
//        ListMultiplicator.multiply(stringList, 2);
//        System.out.println(stringList);
//
//        ListMultiplicator.multiply(stringList, 3);
//        System.out.println(stringList);
//
//        ListMultiplicator.multiply(stringList, 0);
//        System.out.println(stringList);
//    }
//}