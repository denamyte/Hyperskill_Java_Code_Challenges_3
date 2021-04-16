/**
 Check whether the class declares public parameterless constructor
 */
class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        try {
            clazz.getConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

}