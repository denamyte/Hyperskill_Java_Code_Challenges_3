import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Class to work with
 */
class ComparatorInspector {

    /**
     * Return Type variable that corresponds to the type parameterizing Comparator.   
     *
     * @param clazz {@link Class} object, should be non null
     * @return {@link Type} object or null if Comparable does not have type parameter
     */
    public static <T extends Comparable<?>> Type getComparatorType(Class<T> clazz) {

        final Type[] giAr = clazz.getGenericInterfaces();
        for (Type type : giAr) {
            if (type instanceof ParameterizedType && ((ParameterizedType) type).getRawType() == Comparable.class) {
                return ((ParameterizedType) type).getActualTypeArguments()[0];
            }
        }
        return null;
    }
}