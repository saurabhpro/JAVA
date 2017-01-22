import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class SynchronizedList {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<>());

		//Adding some elements to the list
		list.add("Pen");
		list.add("Notebook");
		list.add("Ink");

		System.out.println("Iterating synchronized list");

		synchronized (list) {
			Iterator<String> iterator = list.iterator();

			while (iterator.hasNext())
				System.out.println(iterator.next() + " ");
		}
	}
}
