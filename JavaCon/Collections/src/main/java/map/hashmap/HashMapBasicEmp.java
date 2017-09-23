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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 */


public class HashMapBasicEmp {

	public static void main(String[] args) {
		HashMap<BasicEmp, String> hashMap = new HashMap<>();

		System.out.println("initial size: " + hashMap.size());

		hashMap.put(new BasicEmp(10), "xxx");
		hashMap.put(new BasicEmp(10), "aaaa");
		hashMap.put(new BasicEmp(10), "aaaa");
		hashMap.put(new BasicEmp(10), "xyxx");

		System.out.println("Size after inserting 4 values with same key: " + hashMap.size());

		Set set = hashMap.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry e = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e.getKey();
			System.out.println(k.id + " " + e.getValue());
		}

		System.out.println("Adding new elements");
		hashMap.put(new BasicEmp(20), "bbbb");
		hashMap.put(new BasicEmp(30), "cccc");
		hashMap.put(new BasicEmp(40), "dddd");

		set = hashMap.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry e = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e.getKey();
			System.out.println(k.id + " " + e.getValue());
		}

		BasicEmp e = new BasicEmp(40);
		String ss = hashMap.get(e);
		System.out.println("Value returned for key 40: " + ss);

		hashMap.remove(e);

		set = hashMap.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry e1 = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e1.getKey();
			System.out.println(k.id + " " + e1.getValue());
		}

		hashMap.clear();
		System.out.println("Size after clear: " + hashMap.size());
	}

	static class BasicEmp {
		private final int id;

		BasicEmp(int id) {
			this.id = id;
		}

		@Override
		public boolean equals(Object obj) {
			BasicEmp e = (BasicEmp) obj;
			return this.id == e.id;
		}

		@Override
		public int hashCode() {
			return id * 10;
		}
	}
}
