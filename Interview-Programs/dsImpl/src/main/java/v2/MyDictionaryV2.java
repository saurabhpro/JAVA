package v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyDictionaryV2<K, V> {

    MyDictionaryV2() {
    }

    Node<K, V>[] table;

    Set<MMap.Entry<K, V>> keySet;

    /**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
    static class Node<K, V> implements MMap.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyDictionaryV2.Node<K, V> next;

        Node(int hash, K key, V value, MyDictionaryV2.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            boolean rv = false;
            if (o == this)
                rv = true;

            if (o instanceof MMap.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

                rv = Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue());
            }
            return rv;
        }
    }

    static final int hash(Object key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = (h = key.hashCode()) ^ (h >>> 16);
        }
        return h;
    }


    // Create a regular (non-tree) node
    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    final V putVal(int hash, K key, V value) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K, V> e;
            K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                //else if (p instanceof HashMap.TreeNode)
                //	e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //	if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        //		treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
}
