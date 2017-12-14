package collection_n;

import java.util.ArrayList;
import java.util.Iterator;

public class A {
	/**
	 * Increases the capacity to ensure that it can hold at least the
	 * number of elements specified by the minimum capacity argument.
	 * <p>
	 * minCapacity the desired minimum capacity
	 */
//	private void grow(int minCapacity) {
//		// overflow-conscious code
//		int oldCapacity = elementData.length;
//		int newCapacity = oldCapacity + (oldCapacity >> 1);
//		if (newCapacity - minCapacity < 0)      newCapacity = minCapacity;
//		if (newCapacity - MAX_ARRAY_SIZE > 0)   newCapacity = hugeCapacity(minCapacity);
//		// minCapacity is usually close to size, so this is a win:
//		elementData = Arrays.copyOf(elementData, newCapacity);
//	}
	public static void main(String[] args) {
		ArrayList i = new ArrayList();
		// ArrayList has a method called grow

		int oldCapacity = 10 /*default*/;
		int newCapacity = oldCapacity + (oldCapacity >> 1); //1010 >> 1 = 0101 => 5
		System.out.println(newCapacity); // 15

		ArrayList<String> languageList = new ArrayList<>();
		languageList.add("C");
		languageList.add("C++");
		languageList.add("Java");

		for (Iterator<String> iterator = languageList.iterator(); iterator.hasNext(); ) {
			String language = iterator.next();
			System.out.println(language);
		}


		Iterator<String> numsIter = languageList.iterator();
		while (numsIter.hasNext()) {
			numsIter.remove(); // without calling next() first - IllegalStateException
		}

	}
}


