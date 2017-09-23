/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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