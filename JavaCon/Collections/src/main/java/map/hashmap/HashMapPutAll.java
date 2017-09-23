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
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 * default HashMap ToString
 * {key=value, ...}
 */
public class HashMapPutAll {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();

		hashMap.put("first", "FIRST INSERTED");
		hashMap.put("second", "SECOND INSERTED");
		hashMap.put("third", "THIRD INSERTED");

		System.out.println("\nCurrent Map: \n" + hashMap);

		HashMap<String, String> subMap = new HashMap<>();
		subMap.put("s1", "S1 INSERTED");
		subMap.put("s2", "S2 INSERTED");

		hashMap.putAll(subMap);
		System.out.println("\nCurrent Map:");

		/*
		* Set<Map.Entry<String, String>> entries = hashMap.entrySet();
		 * directly mapping entrySet to type specific set
		 * and using foreach loop instead of explicit Iterator
		 */
		Set<Entry<String, String>> entries = hashMap.entrySet();
		for (Entry<String, String> ent : entries)
			System.out.println(ent.getKey() + "=" + ent.getValue());
	}
}
