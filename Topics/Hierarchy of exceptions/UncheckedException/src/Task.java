// update the class
class UncheckedException extends RuntimeException {
    public UncheckedException() {

    }
}

class Task {
    public static void main(String[] args) {
        UncheckedException uncheckedException = new UncheckedException();
        System.out.println(uncheckedException instanceof RuntimeException);
    }
}
