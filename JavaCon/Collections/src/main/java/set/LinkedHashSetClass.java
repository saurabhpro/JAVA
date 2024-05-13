package set;

import java.util.LinkedHashSet;

public class LinkedHashSetClass {

    public static void main(String[] args) {

        final var hm = new LinkedHashSet<Integer>();
        hm.add(100);
        hm.add(101);
        hm.add(102);
        hm.addFirst(99);
        hm.addLast(103);

        hm.forEach(System.out::println);

        // java 21 updates
        System.out.println("getFirst: " + hm.getFirst());
        System.out.println("getLast: " + hm.getLast());

        System.out.println("reversed: " + hm.reversed());

        System.out.println("removeFirst: " + hm.removeFirst());
        System.out.println("removeLast: " + hm.removeLast());
    }

}
