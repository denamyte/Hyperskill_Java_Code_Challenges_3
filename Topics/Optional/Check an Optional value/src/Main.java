import java.util.Optional;

class Main {
    public static void main(String[] args) {
        ValueProvider provider = new ValueProvider();
        provider.getValue().ifPresent(System.out::println);
    }
}
