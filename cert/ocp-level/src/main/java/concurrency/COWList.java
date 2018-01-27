package concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ModifyingList {
	public static void main(String[] args) {
		List<String> aList = new ArrayList<>();
		aList.add("one");
		aList.add("two");
		aList.add("three");

		Iterator listIter = aList.iterator();
		while (listIter.hasNext()) {
			System.out.println(listIter.next());
			aList.add("four");
		}

		/*
		Because the iterators of ArrayList are fail-fast; it fails by throwing ConcurrentModificationException
		if it detects that the underlying container has changed when it is iterating over the elements in the container.
		 */
	}
}

public class COWList {
	public static void main(String[] args) {
		List<String> aList = new CopyOnWriteArrayList<>();
		aList.add("one");
		aList.add("two");
		aList.add("three");

		Iterator listIter = aList.iterator();
		while (listIter.hasNext()) {
			System.out.println(listIter.next());
			aList.add("four");
		}

		/*
		one
		two
		three
		Observe that the element “four” added three times is not printed as part of the output.
		This is because the iterator still has access to the original (unmodified) container that had three elements.
		If you create a new iterator and access the elements, you will find that new elements have been added to aList.
		 */

		for (Object anAList : aList) {
			System.out.println(anAList);
		}
		/*
		one
		two
		three
		four
		four
		four
		 */
	}
}