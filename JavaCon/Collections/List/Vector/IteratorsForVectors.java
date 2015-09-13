import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class IteratorsForVectors {

    static class VectorIterators {
        Vector<Integer> list = new Vector<>();
        /*
        cannot use List<Integer> here as elements method isn't there in List base interface,
        so wont be able to use it
        */
        ListIterator<Integer> listIterator = null;
        Iterator<Integer> iterator = null;
        Enumeration<Integer> enumeration = null;

        VectorIterators() {
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

        void enumerationLegacyIter() {
            enumeration = list.elements();
            System.out.println("Elements found through Legacy Enumeration (Not-Fail Fast)");
            while (enumeration.hasMoreElements())
                System.out.print(enumeration.nextElement() + " ");
        }
    }

    public static void main(String[] args) {
        VectorIterators vectorIterators = new VectorIterators();
        vectorIterators.Iterator();
        vectorIterators.listIterator();
        vectorIterators.enumerationLegacyIter();
    }

}
