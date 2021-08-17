import java.util.List;
import java.util.Optional;

class Main {
    public static void main(String[] args) {
        final int sum = new ValueProvider().getValues().stream()
                .filter(Optional::isPresent)
                .mapToInt(Optional::get)
                .sum();
        System.out.println(sum);
    }

//    static class ValueProvider {
//        public List<Optional<Integer>> getValues() {
//            return List.of(
//                    Optional.of(1),
//                    Optional.of(2),
//                    Optional.empty(),
//                    Optional.of(4),
//                    Optional.of(5)
//            );
//        }
//    }
}