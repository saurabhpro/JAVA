package sybex.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArray {
	public static void main(String[] args) {
		String[] strArr = new String[]{"One", "Two"};

		List<String> stringList = Arrays.asList(strArr);

		//can result in ClassCastException
		String[] strings1 = (String[]) stringList.toArray();
		//like this
		//Integer[] integers1 = (Integer[]) stringList.toArray(); // will fail

		String[] strings2 = stringList.toArray(new String[0]);
		// or like this
		// Integer[] integers2 = stringList.toArray(new Integer[0]);   // will fail (Still this is better)
		String[] strings3 = stringList.toArray(new String[]{});


		// fails
		// Number[] integers3 = (Integer []) stringList.toArray(); // compilation allowed
		// Number[] integers4 =  stringList.toArray(new Integer[]{}); // compilation allowed

		// but mixing parent and child array operators not allowed
		List<Number> numberList = new ArrayList<Number>();
		numberList.add(Integer.valueOf(77));
		numberList.add(new Integer(77));
		numberList.add(77);

		numberList.forEach(System.out::println);

	}
}
