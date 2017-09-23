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

import java.util.*;

/**
 * Created by Saurabh on 10/5/2015.
 */
public class SynchronizedHashMap {
	@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<>();

		hashMap.put(2, "Anil");
		hashMap.put(44, "Ajit");
		hashMap.put(4, "Sachin");
		hashMap.put(88, "xyz");

		Map map = Collections.synchronizedMap(hashMap);

		Set set = map.entrySet();

		synchronized (map) {
			Iterator iterator = set.iterator();
			//noinspection WhileLoopReplaceableByForEach
			while (iterator.hasNext()) {
				Map.Entry e = (Map.Entry) iterator.next();
				System.out.println(e.getKey() + " " + e.getValue());
			}
		}
	}
}
