import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 * default HashMap ToString
 * {key=value, ...}
 */
public class HashMapPutAll {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();

		hashMap.put("first", "FIRST INSERTED");
		hashMap.put("second", "SECOND INSERTED");
		hashMap.put("third", "THIRD INSERTED");

		System.out.println("\nCurrent Map: \n" + hashMap);

		HashMap<String, String> subMap = new HashMap<>();
		subMap.put("s1", "S1 INSERTED");
		subMap.put("s2", "S2 INSERTED");

		hashMap.putAll(subMap);
		System.out.println("\nCurrent Map:");

		/**Set<Map.Entry<String, String>> entries = hashMap.entrySet();
		 * directly mapping entrySet to type specific set
		 * and using foreach loop instead of explicit Iterator
		 */
		Set<Entry<String, String>> entries = hashMap.entrySet();
		for (Entry<String, String> ent : entries)
			System.out.println(ent.getKey() + "=" + ent.getValue());
	}
}
