package utils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Saurabh on 9/6/2015.
 * Sort kiss basis pe karega Collections.sort(..)
 * String has already implemented Comparable so hume karne ka jaroort nhi padta,
 * but if we are to apply Collections.sort(List myclass), compiler ko batana parega kis basis pe sort kare
 * More on ArrayListEmpSortComparable
 */
public class ComparableString {
	public static void main(String[] args) {
		ArrayList<String> listofcountries = new ArrayList<>();
		listofcountries.add("China");
		listofcountries.add("US");
		listofcountries.add("India");
		listofcountries.add("Denmark");
		listofcountries.add("Russia");

		System.out.println("Before Sorting: ");
		for (String str : listofcountries)
			System.out.print(str + " ");

		Collections.sort(listofcountries);

        /*
        Collections.sort(List<T>);
        Collections.sort(List<T>, Comparator<? super T);
         */

		System.out.println("\n\nAfter Sorting");
		listofcountries.stream().map(str -> str + " ").forEach(System.out::print);
	}
}
/*OUTPUT
Before Sorting:
China US India Denmark China
After Sorting
China China Denmark India US
 */