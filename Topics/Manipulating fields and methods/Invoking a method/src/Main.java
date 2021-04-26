import java.lang.reflect.InvocationTargetException;

class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println(SomeClass.class.getDeclaredMethods()[0].invoke(new SomeClass()));
    }
}
