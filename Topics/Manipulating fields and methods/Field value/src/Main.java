/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) {
        try {
            return object.getClass().getField(fieldName).get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

//    static class TestClass {
//        private int privateField = -1;
//        public int publicField = 1;
//    }
//
//    public static void main(String[] args) {
//        final TestClass instance = new TestClass();
//        final FieldGetter fg = new FieldGetter();
//        Stream.of("nonExistent", "privateField", "publicField")
//                .forEach(fieldName -> System.out.printf(
//                        "Getting the field '%s' value: %s%n", fieldName, fg.getFieldValue(instance, fieldName)));
//    }
}