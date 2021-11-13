package cvent.yaml;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * memoizer for java
 *
 * @param <T> input type
 * @param <R> return type
 */
public final class Memoize<T, R> {

    private final Map<T, R> cache;

    private Memoize(Supplier<Map<T, R>> mapConstructor) {
        this.cache = mapConstructor.get();
    }

    private Map<T, R> getCache() {
        return cache;
    }

    /**
     * memoizes a function, saving results to a cache that is created using mapConstructor.
     * @param calculate
     * @param mapConstructor
     * @param <T>
     * @param <R>
     * @return memoized variant of the input Function accepting T and returning R
     */
    public static <T, R> Function<T, R> memoize(Function<T, R> calculate, Supplier<Map<T, R>> mapConstructor) {
        Memoize<T, R> memoize = new Memoize<>(mapConstructor);
        return key -> {
            if (!memoize.getCache().containsKey(key)) {
                memoize.getCache().put(key, calculate.apply(key));
            }
            return memoize.getCache().get(key);
        };
    }

    /**
     * memoizes a function, saving results to a cache.
     * @param calculate
     * @param <T>
     * @param <R>
     * @return memoized variant of the input Function accepting T and returning R
     */
    public static <T, R> Function<T, R> memoize(Function<T, R> calculate) {
        return memoize(calculate, HashMap::new);
    }
}
