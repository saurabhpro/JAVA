/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Saurabh on 10/5/2015.
 * it is exactly same as the HashMap except for the following point
 * <p>
 * HashMap key object is not garbage collected even when we set its strong reference to null
 * i.e. t1 = null;  //hashmap entry not deleted
 * it doesnt have any external references if it is associated with HashMap
 * <p>
 * WeakHashMap key object has weak reference
 * i.e. if the key is garbage collected then that entry in WeakHashMap object will be deleted automatically
 * This is not the case in HashMap
 * <p>
 * Example: See Output: The entry of WeakHashMap object is deleted after t2=null;
 */
public class WeakHashMapClass {
	public static void main(String[] args) {
		Map<Object, Object> hashMap = new HashMap<>();
		Map<Temporary, String> weakHashMap = new WeakHashMap<>();

		Temporary t1 = new Temporary();
		Temporary t2 = new Temporary();

		hashMap.put(t1, "sai");
		System.out.println("Before HashMap Gets Garbage Collected: ");
		System.out.println(hashMap);

		//noinspection UnusedAssignment
		t1 = null;
		System.gc();
		System.out.println("After HashMap gets Garbage Collected: ");
		System.out.println(hashMap);

		weakHashMap.put(t2, "sai");
		System.out.println("Before WeakHashMap Gets Garbage Collected: ");
		System.out.println(weakHashMap);

		//noinspection UnusedAssignment
		t2 = null;
		System.gc();
		System.out.println("After WeakHashMap gets Garbage Collected: ");
		System.out.println(weakHashMap);


	}

	private static class Temporary {
		@Override
		public String toString() {
			return "Temporary";
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("Finalize method called");
			super.finalize();
		}
	}
}
