package map.hashmap;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 * <p>
 * here the additional thing we did is that our hashcode for two objects is similar
 * only when both there itemName and itemPrice is same,
 * eg. Apple40, and Apple41 is not same
 */
public class HashMapHashCodeEquals {
	public static void main(String[] args) {
		HashMap<Price, String> hashMap = new HashMap<>();

		hashMap.put(new Price("Banana", 20), "Banana");
		hashMap.put(new Price("Apple", 40), "Apple");
		hashMap.put(new Price("Orange", 30), "Orange");
		hashMap.put(new Price("Apple", 41), "Mango");

		printMap(hashMap);

		Price key = new Price("Banana", 20);    //object banne se hashcode nhi bna, only when we operate tb hi

		System.out.println("\nChecking for equals");
		System.out.println("Does key Available : " + hashMap.containsKey(key));
		System.out.println("Does Value Available : " + hashMap.containsValue("Banana"));

		System.out.println("\nDeleting");
		System.out.println("Deleting key \"Banana\",20");
		hashMap.remove(key);
		System.out.println("After deleting key \"Banana\",20");
		printMap(hashMap);
	}

	private static void printMap(HashMap<Price, String> hashMap) {
		Set<Price> keySet = hashMap.keySet();

		System.out.println("\nCurrent Map");
		for (Price p : keySet)
			System.out.println(p + " " + hashMap.get(p));

		/* while running get(p) hashcode is checked again so output contains hashcode lines */

	}

	static class Price {
		private final String itemName;
		private final int itemPrice;

		Price(String item, int price) {
			itemName = item;
			itemPrice = price;
		}

		@Override
		public int hashCode() {
			System.out.println("HashCode for " + itemName + itemPrice);

			int hashCode;

			hashCode = itemPrice * 10;
			hashCode += itemName.hashCode();

			return hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			System.out.println("Inside Equals");

			if (obj instanceof Price) {
				Price price = (Price) obj;

				return (price.itemName.equals(this.itemName) && price.itemPrice == this.itemPrice);
			} else
				return false;
		}

		@Override
		public String toString() {
			return "Item: " + itemName + " Price: " + itemPrice;
		}
	}
}
