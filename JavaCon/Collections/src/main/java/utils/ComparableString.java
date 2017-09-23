/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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