package cvent.yaml;

//import com.google.common.annotations.VisibleForTesting;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All the nasty reflection-based routines that we need under the hood.
 *
 * @author bszymanski@cvent.com
 */
public final class NastyReflectionStuff {

    private NastyReflectionStuff() { }

    /**
     * Brutally ignores encapsulation to find a fields associated with a class by name, regardless
     * of access control and inheritance. Finds fields all the way up the chain using the algorithm
     * of Class::getField (but extended to include non-public fields). This boils down to: first
     * check the object, then all superinterfaces, then finally any superclass, recursively.
     * @param klazz
     * @param fieldName
     * @return java.lang.reflect.Field
     * @throws NoSuchFieldException
     */
    public static Field getField(Class<?> klazz, String fieldName) throws NoSuchFieldException {
        Field field = getFields(klazz).get(fieldName);
        if (field == null) {
            throw new NoSuchFieldException(fieldName);
        }
        return field;
    }

    /**
     * Brutally ignores encapsulation to find all fields associated with a class by name, regardless
     * of access control and inheritance. Finds fields all the way up the chain using the algorithm
     * of Class::getField (but extended to include non-public fields). This boils down to: first
     * check the object, then all superinterfaces, then finally any superclass, recursively.
     * @param klazz
     * @return java.lang.reflect.Field
     */
    public static Map<String, Field> getFields(Class klazz) {
        return Memoize.memoize(
                (Class c) -> getSelfAndSuperClasses(c).stream()
                        .flatMap(c2 -> Arrays.stream(c2.getDeclaredFields()))
                        .filter(distinctByKey(Field::getName))
                        .collect(Collectors.toMap(Field::getName, Function.identity()))
        ).apply(klazz);
    }

//    @VisibleForTesting
    protected static List<Class> getSuperClasses(Class klazz) {
        return Memoize.memoize(
                (Class c) -> Stream.concat(Arrays.stream(c.getInterfaces()), Stream.ofNullable(c.getSuperclass()))
                        .flatMap(c2 -> getSelfAndSuperClasses(c2).stream())
                        .distinct()
                        .collect(Collectors.toList())
        ).apply(klazz);
    }

//    @VisibleForTesting
    protected static List<Class> getSelfAndSuperClasses(Class klazz) {
        return Stream.concat(Stream.of(klazz), getSuperClasses(klazz).stream()).collect(Collectors.toList());
    }

//    @VisibleForTesting
    protected static <T, U> Predicate<T> distinctByKey(Function<T, U> keyExtractor) {
        Map<U, Boolean> seen = new HashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), true) == null;
    }
}
