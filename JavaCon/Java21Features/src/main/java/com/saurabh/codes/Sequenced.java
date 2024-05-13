package com.saurabh.codes;

import static java.util.HashMap.newHashMap;

public class Sequenced {

    public static void main(String[] args) {
//        interface SequencedMap<K, V> extends Map<K, V> {

//            // new methods
//            SequencedMap<K, V> reversed();
//            SequencedSet<K> sequencedKeySet();
//            SequencedCollection<V> sequencedValues();
//            SequencedSet<Entry<K, V>> sequencedEntrySet();
//
//            V putFirst(K, V);
//            V putLast(K, V);
//
//            // methods promoted from NavigableMap
//            Entry<K, V> firstEntry();
//            Entry<K, V> lastEntry();
//            Entry<K, V> pollFirstEntry();
//            Entry<K, V> pollLastEntry();

        final var map = newHashMap(10);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
    }

}
