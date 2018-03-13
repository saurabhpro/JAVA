package collection_n.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSort {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Fluffy", "Hoppy");  // ascending

		Comparator<String> c = Comparator.reverseOrder();   //decending

		int index = Collections.binarySearch(names, "Hoppy", c);    // -1 as trying to search ascending in decending way

		System.out.println(index);


		Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
		List<Integer> list = Arrays.asList(5, 4, 7, 1);
		Collections.sort(list, c1);
		System.out.print(list + " : ");
		System.out.println(Collections.binarySearch(list, 1));
	}
}
