// Do not remove imports

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Scanner;

class TypeVariablesInspector {
    Scanner dumbScanner;

    public void printTypeVariablesCount(TestClass obj, String methodName) throws Exception {
//    public void printTypeVariablesCount(Object obj, String methodName) throws Exception {
        final Method method = obj.getClass().getDeclaredMethod(methodName);
        System.out.println(method.getTypeParameters().length);
    }
}