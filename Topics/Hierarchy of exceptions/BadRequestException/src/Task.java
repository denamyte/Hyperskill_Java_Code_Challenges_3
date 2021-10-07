// update the class
class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}

// do not change this code
class Main {
    public static void main(String[] args) {
        BadRequestException badRequestException = new BadRequestException("Bad Request");
        System.out.println(badRequestException instanceof Exception);
    }
}
