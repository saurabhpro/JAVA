package arrayList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class ArrayListEquality {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ii");
		list.add("op");

		List<String> list2 = new ArrayList<>();
		list2.add("ii");
		list2.add("op");

		if (list.equals(list2))
			System.out.println("Array list has overriden equals - so same content is equal");


		//String[] arr = list.toArray();
		Object[] arr = list.toArray();

		String[] stringArray = list.toArray(new String[0]);// 0 can be any number new String[5] too - doesnt matter ?
		System.out.println(stringArray.length + " = " + Arrays.toString(stringArray));
		System.out.println("LO: " + (stringArray == stringArray));

		List<String> li = Arrays.asList("oo", "iio");
		li = Arrays.asList("oo", "iio8"); // overwritable
		System.out.println(li);


		List<String> hex = Arrays.asList("30", "8", "3A", "FF");    // creates fixed sized list see - below
		Collections.sort(hex);
		int x = Collections.binarySearch(hex, "8");
		int y = Collections.binarySearch(hex, "3A");
		int z = Collections.binarySearch(hex, "4F");
		System.out.println(x + " " + y + " " + z);          // [30, 3A, 8, FF]

		Object[] objects = hex.toArray();
		// String[] objects1 = hex.toArray();
		String[] strings = hex.toArray(new String[]{});  // or new String[0]    -> then it will act a <T>
		System.out.println(Arrays.toString(strings));   // array don't have toString implcitly


		System.out.println("see      : " + hex.getClass().toGenericString());
		System.out.println("replaced : " + hex.set(1, "9"));

		UnaryOperator<String> uo = (i) -> i + "x";
		hex.replaceAll(uo); // returns void if success
		System.out.println("replaced : " + uo.getClass().toGenericString());
		System.out.println("see      : " + hex);
		/*
		see      : [30, 3A, 8, FF]
		replaced : 3A
		see      : [30, 9, 8, FF]
		 */

		// hex.add("00");  // returns <T> is successful
		// hex.add(1, "8");    // returns void
		// hex.addAll(hex);    // returns boolean  if this list changed as a result of the call

		// hex.removeIf(i -> i.length() < 2);
		System.out.println("see : " + hex);

		java.util.ArrayList i9 = new java.util.ArrayList();
		//i9.remove(0);

	}
}


