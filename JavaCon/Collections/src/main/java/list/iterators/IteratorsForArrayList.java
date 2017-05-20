package list.iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class IteratorsForArrayList {

	public static void main(String[] args) {
		ListIterators listIterators = new ListIterators();
		listIterators.Iterator();
		listIterators.listIterator();

	}

	static class ListIterators implements ListOp {
		List<Integer> list = new ArrayList<>();

		ListIterators() {
			list.add(23);
			list.add(98);
			list.add(29);
			list.add(71);
			list.add(5);
		}

		void listIterator() {
			listIterator(list);
		}

		void Iterator() {
			iterator(list);
		}
	}

}
