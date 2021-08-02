// You can experiment here, it won’t be checked

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Task {
    public static void main(String[] args) {
        Callable<String> callable = CallableUtil.getCallable();
        System.out.println(callable);
    }
}

class CallableUtil {
    public static Callable<String> getCallable() {
        String s = new Scanner(System.in).nextLine();
        return () -> s;
    }
}
