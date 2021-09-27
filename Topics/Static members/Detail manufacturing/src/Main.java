class ManufacturingController {

    private static int counter = 0;

    public static String requestProduct(String product) {
        return String.format("%d. Requested %s", counter += 1, product);
    }

    public static int getNumberOfProducts() {
        return counter;
    }
}