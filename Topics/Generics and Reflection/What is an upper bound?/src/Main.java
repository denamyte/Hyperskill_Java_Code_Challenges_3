// Do not remove imports
import java.lang.reflect.*;
import java.util.*;

class ListParameterInspector {
    // Do not change the method
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String methodName = scanner.next();

        ListParameterInspector inspector = new ListParameterInspector();
        inspector.printParameterType(new TestClass(), methodName);
    }

    public void printParameterType(TestClass obj, String methodName) throws Exception {
//    public void printParameterType(Object obj, String methodName) throws Exception {
        final Method m = Arrays.stream(obj.getClass().getDeclaredMethods())
                .filter(method -> method.getName().equals(methodName)).findFirst().orElseThrow();
        ParameterizedType type = (ParameterizedType) m.getGenericReturnType();
        WildcardType arg = (WildcardType) type.getActualTypeArguments()[0];
        Type upperBound = arg.getUpperBounds()[0];
        System.out.println(upperBound.getTypeName());
    }
}