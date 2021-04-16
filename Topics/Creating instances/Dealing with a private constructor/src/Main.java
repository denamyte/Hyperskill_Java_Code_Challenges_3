import java.lang.reflect.Constructor;
import java.util.Arrays;

class InstanceUtils {

    public static Person createPerson(String name, int age) {
        Class<Person> personClass = Person.class;
        final Constructor<> twoParamConstructor = Arrays.stream(personClass.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() == 2)
                .findAny().orElseThrow();
        try {
            twoParamConstructor.setAccessible(true);
            return (Person) twoParamConstructor.newInstance(name, age);
        } catch (Exception e) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        final Person andrew = createPerson("Andrew", 25);
//        if (andrew == null) {
//            System.out.println("null");
//        } else {
//            System.out.printf("Name: %s; age: %d", andrew.getName(), andrew.getAge());
//        }
//    }

}

//class Person {
//    private String name = "unknown";
//    private int age;
//
//    private Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    private Person(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//}