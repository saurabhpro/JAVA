package v2;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;

public interface MMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey();

    boolean containsValue();

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    void clear();

    Set<K> keySet();

    Collection<V> getValues();

    Set<MMap.Entry<K, V>> entrySet();


    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);

        for (MMap.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }

            action.accept(k, v);
        }
    }


    interface Entry<K, V> {
        static <K extends Comparable<? super K>, V> Comparator<MMap.Entry<K, V>> comparingByKey() {

            return (Comparator<MMap.Entry<K, V>> & Serializable) ((c1, c2) -> c1.getKey().compareTo(c2.getKey()));
        }

        K getKey();

        V getValue();

        V setValue(V val);
    }


}
