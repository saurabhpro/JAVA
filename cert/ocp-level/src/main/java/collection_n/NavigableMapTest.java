package collection_n;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * It has many methods that make Map navigation easy.
 * You can get the nearest value matching the given key, all values less than the given key,
 * all values greater than the given key, and so on.
 */
public class NavigableMapTest {
	public static void main(String[] args) {
		NavigableMap<Integer, String> examScores = new TreeMap<>();
		examScores.put(90, "Sophia");
		examScores.put(20, "Isabella");
		examScores.put(10, "Emma");
		examScores.put(50, "Olivea");
		System.out.println("The data in the map is: " + examScores);
		System.out.println("The data descending order is: " + examScores.descendingMap());
		System.out.println("Details of those who passed the exam: " + examScores.tailMap(40));  // gives submap
		System.out.println("Details of those who failed the exam: " + examScores.headMap(40));  // gives submap
		System.out.println("The lowest mark is: " + examScores.firstEntry());   // since ascending
	}
}
