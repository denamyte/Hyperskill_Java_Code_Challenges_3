import java.util.Comparator;
import java.util.List;

class Utils {

    public static final Comparator<Integer> ODD_EVEN_COMP = (n1, n2) -> {
        boolean odd1 = (n1 & 1) == 1;
        boolean odd2 = (n2 & 1) == 1;
        return odd1 && odd2 ? Integer.compare(n1, n2)
                : !odd1 && !odd2 ? Integer.compare(n2, n1)
                : odd1 ? -1
                : 1;
    };

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        numbers.sort(ODD_EVEN_COMP);
        return numbers;
    }
}