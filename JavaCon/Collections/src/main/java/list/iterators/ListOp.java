package list.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by saurabhkumar on 20/05/17.
 */
public interface ListOp {
	default void listIterator(List<Integer> list) {
		ListIterator<Integer> listIterator = list.listIterator();

		System.out.println("\nElements found in FORWARD Direction");
		while (listIterator.hasNext())
			System.out.print(listIterator.next() + " ");

		System.out.println("\nElements found in BACKWARD Direction");
		while (listIterator.hasPrevious())
			System.out.print(listIterator.previous() + " ");
	}

	default void iterator(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		System.out.println("Elements found through Simple Iterator");
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
	}
}

