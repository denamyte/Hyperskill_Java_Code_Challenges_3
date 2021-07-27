import java.util.Arrays;

class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        Arrays.stream(threads)
                .filter(t -> t.getState() == Thread.State.TERMINATED)
                .map(Thread::getName)
                .forEach(System.out::println);
    }
}