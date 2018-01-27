package collection_n;

import java.util.*;

/**
 * TreeMap      —   no null keys
 * Hashtable    —   no null keys or values
 * TreeSet      —   no null elements
 * ArrayDeque   —   no null elements
 */
public class DontAllowNull {
	public static void main(String[] args) {
		// The data structures that involve sorting do not allow nulls. since you cant compare null <, > etc
		TreeSet<String> i = new TreeSet<>();
		try {
			i.add(null);
		} catch (NullPointerException ignored) {
			System.out.println("TreeSet don't allow null as cannot be used in compareTo");
		}


		Map<Integer, Integer> m = new TreeMap<>();
		m.put(9, null);
		try {
			m.put(null, 8);
		} catch (NullPointerException ignored) {
			System.out.println("TreeMap don't allow null key as cannot be used in compareTo - null value is ok : " + m);
		}

		m = new HashMap<>();
		m.put(null, 8);
		m.put(null, 9); // overwrites 8
		System.out.println("HashMap allows null key however - but obviously only 1 of the keys can be null : " + m);
		m.get(null);    // 9


		ArrayDeque<String> d = new ArrayDeque<>();
		try {
			d.offer(null);
		} catch (NullPointerException ignored) {
			System.out.println("Deque don't allow null as null is reserved for special use by peek when empty : " + d.peek());
		}

	}
}
