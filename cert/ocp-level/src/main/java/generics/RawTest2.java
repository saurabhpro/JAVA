package generics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RawTest2 {
	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("First");
		list.add("Second");

		List<String> strList = list;
		//strList.add(10);        // #1: generates compiler error
		// list.add(88); // also compiles but throws ClassCastException
		for (String aStrList : strList) System.out.println("Item : " + aStrList);

		List<String> strList2 = new LinkedList<>();
		strList2.add("First");
		strList2.add("Second");

		List list2 = strList2;
		list2.add(10); // #2: compiles fine, results in runtime exception
		// strList2.add(10);   // is obviously an error

		for (Iterator<String> itemItr = list2.iterator(); itemItr.hasNext(); )
			System.out.println("Item : " + itemItr.next());
	}
}