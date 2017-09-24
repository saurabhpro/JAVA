package Ch13_Java.Q13_05_TreeMap_HashMap_LinkedHashMap;

import java.util.*;

public class Question {
	private static void insertAndPrint(Map<Integer, String> map) {
		int[] array = {1, -1, 0, 3, 2};

		Arrays.stream(array).forEach(x -> map.put(x, Integer.toString(x)));

		for (int k : map.keySet()) {
			System.out.print(k + ", ");
		}
	}

	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		HashMap<Integer, String> hashMap = new HashMap<>();
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		System.out.println("HashMap - Arbitrary Order:");
		insertAndPrint(hashMap);

		System.out.println("\n\nLinkedHashMap - Insertion Order:");
		insertAndPrint(linkedHashMap);

		System.out.println("\n\nTreeMap - Natural Order:");
		insertAndPrint(treeMap);
	}

}
