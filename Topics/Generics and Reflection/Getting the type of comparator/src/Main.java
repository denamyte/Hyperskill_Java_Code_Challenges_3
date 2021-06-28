import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Comparator;

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
//
//        final Type comparable = Arrays.stream(clazz.getGenericInterfaces())
//                .filter(type -> type instanceof Comparable)
//                .findFirst().orElse(null);
//        if (comparable instanceof ParameterizedType) {
//            ParameterizedType type = (ParameterizedType) comparable;
//            type.getRawType()
//            final Type[] typeArguments = type.getActualTypeArguments();
//            return typeArguments.length == 0 ? null : typeArguments[0];
//        }
//        if (comparable instanceof WildcardType) {
//            WildcardType type = (WildcardType) comparable;
//            final Type[] upperBounds = type.getUpperBounds();
//            return upperBounds.length == 0 ? null : upperBounds[0];
//        }
//        return null;
    }
}