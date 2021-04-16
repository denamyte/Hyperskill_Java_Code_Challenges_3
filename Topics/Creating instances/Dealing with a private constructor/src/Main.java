import java.lang.reflect.Constructor;
import java.util.Arrays;

class InstanceUtils {

    public static Person createPerson(String name, int age) {
        Class<Person> personClass = Person.class;
        final Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(c -> {
            for (Class<?> param : c.getParameterTypes()) {
                System.out.println(param);
            }
        });

        return null;
    }

    public static void main(String[] args) {
        createPerson("Andrew", 25);
    }
}

class Person {
    private String name = "unknown";
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    // getters
}