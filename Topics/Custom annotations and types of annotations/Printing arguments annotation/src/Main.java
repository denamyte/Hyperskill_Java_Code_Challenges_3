import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface PrintArgs {
    boolean printReturn();
}

class TestClass {
    @PrintArgs(printReturn = true)
    public void myMethod() {
        // some code
    }
}