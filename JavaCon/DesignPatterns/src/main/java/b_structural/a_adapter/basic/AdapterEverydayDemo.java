package b_structural.a_adapter.basic;

import java.util.Arrays;
import java.util.List;

public class AdapterEverydayDemo {

	public static void main(String args[]) {

		Integer[] arrayOfInts = new Integer[]{42, 43, 44};

		List<Integer> listOfInts = Arrays.asList(arrayOfInts);

		System.out.println(Arrays.toString(arrayOfInts));

		System.out.println(listOfInts);

	}
}
