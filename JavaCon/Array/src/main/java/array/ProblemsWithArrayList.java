package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProblemsWithArrayList {

    public static void main(String[] args) {
        asListVsListOf();
        collectionVsArrayList();
    }

    private static void asListVsListOf() {
        final var mutableButNotReally = Arrays.asList(3, 6, 9);

        System.out.println(mutableButNotReally);

        // add doesn't work
        try {
            mutableButNotReally.add(12);
        } catch (UnsupportedOperationException ex) {
            System.out.println("add() in asList is not allowed");
        }

        // but value at index can be changed
        mutableButNotReally.set(1, 5);
        System.out.println(mutableButNotReally);

        // with List.of() .set is also not allowed
        try {
            final var listOf = List.of(3, 6, 9);
            listOf.set(1, 5);
        } catch (UnsupportedOperationException ex) {
            System.out.println("set() in List.of is not allowed");
        }
    }

    private static void collectionVsArrayList() {
        final Collection<Integer> baseObjectOperation = new ArrayList<>(List.of(3, 6, 9, 12));
        System.out.println(baseObjectOperation);
        baseObjectOperation.remove(3);
        System.out.println(baseObjectOperation); // 6, 9, 12

        final var listOverloadWithIndex = new ArrayList<>(List.of(3, 6, 9, 12));
        System.out.println(listOverloadWithIndex);
        listOverloadWithIndex.remove(3);
        System.out.println(listOverloadWithIndex); // 3, 6, 9
    }
}
