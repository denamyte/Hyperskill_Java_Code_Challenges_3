import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FunctionUtils {
    // This problem is kind of ... ahem, one-liner.
    public static <T> Supplier<Stream<T>> saveStream(Stream<T> stream) {
        return stream.collect(Collectors.toList())::stream;
    }
}