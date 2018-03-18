/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package generics.array;

public class ArrayOfGenerics {
	public static void main(String[] args) {
		Integer[] iAr = {1, 2, 3};

		//Normal array of similar type
		GenItem<Integer> iOb = new GenItem<>(50, iAr);
		iOb.showItems();

		//Array of two Integers types
		//noinspection unchecked
		GenItem<Integer>[] n2 = new GenItem[2];
		n2[0] = new GenItem<>(49, iAr);  //Type fixed before compilation
		n2[0].showItems();


		//these techniques give Object Placeholder by default to T

		GenItem[] n = new GenItem[2]; //fine
		//Automatic Type Inference
		n[0] = new GenItem<>(88, iAr);  //<> is filled by (Object, Object[]), so sab allowed hojata h
		n[0].showItems();
		n[1] = new GenItem<>("Hathi", new Float[]{8.9f, 7.6f});
		n[1].showItems();

		//Other way is to use generics.Wildcards
		GenItem<?>[] genAr = new GenItem<?>[2]; //two elements in an array whose types are not defined til compilation
		genAr[0] = new GenItem<>(76, iAr);  //now Integer replaces T so Fixed for both arguments
		//<> leave it empty for Object to replace T -> different types
		genAr[0].showItems();
		genAr[0] = new GenItem<>("Hathi", new String[]{"Hello", "World"});
		genAr[0].showItems();
		genAr[1] = new GenItem<>(8.9f, new Float[]{8.9f, 7.6f, 1.2f});
		genAr[1].showItems();

	}
}