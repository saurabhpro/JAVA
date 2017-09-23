/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class ReverseShuffleSublistSwapSetTrim {
	private static final ArrayList<String> arrayList = new ArrayList<>();

	private ReverseShuffleSublistSwapSetTrim() {
		arrayList.add("One");
		arrayList.add("Two");
		arrayList.add("Three");
		arrayList.add("Four");
	}

	public static void main(String[] args) {
		ReverseShuffleSublistSwapSetTrim rOb = new ReverseShuffleSublistSwapSetTrim();
		rOb.reverse();
		rOb.shuffle();
		rOb.ensureCapacity(50);

		ReverseShuffleSublistSwapSetTrim.SetSublistAndTrimIntegerList ob = rOb.new SetSublistAndTrimIntegerList();
		ob.setArrayListEx();
		ob.trim();
		ob.subList();
		ob.swapList();
	}

	private void shuffle() {
		System.out.println("List Before Shuffle: ");
		for (String str : arrayList)
			System.out.print(str + " ");

		Collections.shuffle(arrayList);
		System.out.println("\nList After First Shuffle:\n" + arrayList);

		Collections.shuffle(arrayList);
		System.out.println("\nList After First Shuffle:\n" + arrayList);
	}

	private void reverse() {
		System.out.println("Actual List: " + arrayList);
		Collections.reverse(arrayList);
		System.out.println("List after Reversing: " + arrayList);
	}

	@SuppressWarnings("SameParameterValue")
	private void ensureCapacity(int n) {
		arrayList.ensureCapacity(n);
		System.out.println(arrayList.size());
		/*
		this give the minimum size the list must have, say we have 4 elements, we can say ensure 5 seats,
        if we go above 5, then grow by half as usual

        There is no capacity method in ArrayList like in Vector so know the current capacity is difficult
         */
	}

	class SetSublistAndTrimIntegerList {
		final ArrayList<Integer> arrayList = new ArrayList<>(50);

		SetSublistAndTrimIntegerList() {
			System.out.println("Initial Size: " + arrayList.size());
			arrayList.add(1);
			arrayList.add(2);
			arrayList.add(3);
			arrayList.add(4);
			arrayList.add(5);
			arrayList.add(6);
		}

		void setArrayListEx() {
			System.out.println("Array List Before Update Set: " + arrayList);
			arrayList.set(0, 11);
			arrayList.set(1, 22);
			arrayList.set(2, 33);
			arrayList.set(3, 44);
			System.out.println("Array List After Update Set: " + arrayList);
		}

		void trim() {
			System.out.println("Size after Adding 6 elements: " + arrayList.size());
			arrayList.trimToSize();
			System.out.println("Size after Trimming: " + arrayList.size());
		/*
		This only shows 6,6 as mentioned there is now way to look for capacity
         */
		}

		void subList() {
			System.out.println("Actual List - " + arrayList);
			List<Integer> list = arrayList.subList(2, 5);
			System.out.println("Sublist is : " + list);
		}

		void swapList() {
			System.out.println("Actual List - " + arrayList);
			Collections.swap(arrayList, 2, 5);
			System.out.println("Swapped List : " + arrayList);
		}
	}
}
