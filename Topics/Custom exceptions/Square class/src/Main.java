import java.util.Scanner;

class Square {
    int a;

    public Square(int a) throws SquareSizeException {
        if (a > 0) {
            this.a = a;
        } else {
            throw new SquareSizeException("zero or negative size");
        }
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new Square(scanner.nextInt());
        } catch (SquareSizeException e) {
            System.out.println(e.getMessage());
        }
    }
}

class SquareSizeException extends Exception {
    static final long serialVersionUID = 3429439922398087631L;

    public SquareSizeException(String message) {
        super(message);
    }
}