package generics;

import java.util.ArrayList;
import java.util.List;

class WildCardUse {
	static void printList(List<?> list) {
		for (Object element : list)
			System.out.println("[" + element + "]");
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(100);
		printList(list);

		List<String> strList = new ArrayList<>();
		strList.add("10");
		strList.add("100");
		printList(strList);

		List<?> wildCardList = new ArrayList<Integer>();
		//wildCardList.add(new Integer(10)); //the compiler doesn’t allow you to call methods that modify the object
		System.out.println(wildCardList);
	}
}

