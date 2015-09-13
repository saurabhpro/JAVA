import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class IteratorsForArrayList {

    static class ListIterators {
        List<Integer> list = new ArrayList<>();
        ListIterator<Integer> listIterator = null;
        Iterator<Integer> iterator = null;

        ListIterators() {
            list.add(23);
            list.add(98);
            list.add(29);
            list.add(71);
            list.add(5);
        }

        void listIterator() {
            listIterator = list.listIterator();

            System.out.println("Elements found in FORWARD Direction");
            while (listIterator.hasNext())
                System.out.print(listIterator.next() + " ");

            System.out.println("Elements found in BACKWARD Direction");
            while (listIterator.hasPrevious())
                System.out.print(listIterator.previous());

        }

        void Iterator() {
            iterator = list.iterator();
            System.out.println("Elements found through Simple Iterator");
            while (iterator.hasNext())
                System.out.print(iterator.next() + " ");
        }
    }


    public static void main(String[] args) {
        IteratorsForArrayList.ListIterators listIterators = new IteratorsForArrayList.ListIterators();
        listIterators.Iterator();
        listIterators.listIterator();

    }

}
