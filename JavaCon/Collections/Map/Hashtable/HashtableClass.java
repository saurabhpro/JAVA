import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Saurabh on 10/5/2015.
 * A Hashtable is an array of list.Each list is known as a bucket.The position of bucket is identified by calling the hashcode() method.A Hashtable contains values based on the key. It implements the Map interface and extends Dictionary class.
 * It contains only unique key elements.
 * It doesnt not any null key or value.
 * It is synchronized.
 */
public class HashtableClass {
	public static void main(String args[]) {

		Hashtable<Integer, String> hm = new Hashtable<>();

		hm.put(100, "Amit");
		hm.put(102, "Ravi");
		hm.put(101, "Vijay");
		hm.put(103, "Rahul");

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}
