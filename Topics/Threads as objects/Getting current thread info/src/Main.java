class Info {

    public static void printCurrentThreadInfo() {
        Thread thread = Thread.currentThread();
        System.out.printf("name: %s%npriority: %d%n", thread.getName(), thread.getPriority());
    }
}