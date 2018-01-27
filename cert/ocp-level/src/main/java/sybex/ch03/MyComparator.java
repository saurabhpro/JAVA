package sybex.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MyComparator implements Comparator<String> {

	public static void main(String[] args) {
		String[] values = {"123", "Abb", "aab"};
		Arrays.sort(values, new MyComparator());


		System.out.println(Arrays.toString(values));


		Map<Integer, Integer> map = new HashMap<>(10);
		for (int i = 1; i <= 10; i++) {
			map.put(i, i * i);
		}
		System.out.println(map.get(4));
	}

	public int compare(String a, String b) {
		//return a.toLowerCase().compareTo(b.toLowerCase());  // increasing order
		return b.toLowerCase().compareTo(a.toLowerCase());  // decreasing order
	}
}
