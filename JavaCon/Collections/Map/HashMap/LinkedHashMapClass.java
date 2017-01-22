import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Saurabh on 10/5/2015.
 * A LinkedHashMap contains values based on the key. It implements the Map interface and extends HashMap class.
 * It contains only unique key elements, and can have duplicate values.
 * It may have one null key and multiple null values.
 * It is same as HashMap instead MAINTAINS INSERTION ORDER!!!
 */
public class LinkedHashMapClass {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}
}
/**
 * OUTPUT [insertion order maintained]
 * 100 Amit
 * 101 Vijay
 * 102 Rahul
 */
