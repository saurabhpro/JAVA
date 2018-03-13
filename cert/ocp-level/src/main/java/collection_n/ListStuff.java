package collection_n;

import java.util.*;

public class ListStuff {
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
			numsIter.next();
			numsIter.remove(); // without calling next() first - IllegalStateException
		}


		List<String> list = new LinkedList<>();
		list.add("Archie");
		list.add("X-Men");
		list.stream().forEach(s -> System.out.println(s));
		list.stream().forEach(s -> System.out.println(s));

		filter();
	}

	private static void filter() {
		/*
		 * “ With method references, only one item can be supplied at runtime.
		 * Here, we need either a String instance with no parameters in the method or a static method with a single parameter.
		 *
		 * The charAt() method is an instance method with a single parameter so does not meet this requirement.”
		 */
		List<String> list = new ArrayList<>();
		list.add("Atlanta");
		list.add("Chicago");
		list.add("New York");
		list.stream()
				.filter(s -> s.isEmpty())
				.forEach(System.out::println);

		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("3", 3);
		map.put("three", 3);
		map.put("THREE", 3);
		System.out.println(map.firstKey() + " " + map.lastKey());


		list = new ArrayList<>();
		list.add("Austin");
		list.add("Boston");
		list.add("San Francisco");
		list.removeIf(a -> a.length() > 10);
		System.out.println(list.size());

		ArrayDeque<Integer> dice = new ArrayDeque<>();
		dice.offer(3);
		dice.offer(2);
		dice.offer(4);
		System.out.print(dice.stream().filter(n -> n != 4));    // java.util.stream.ReferencePipeline$2@5b6f7412

	}
}


