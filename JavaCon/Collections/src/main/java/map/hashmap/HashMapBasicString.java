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
 * HashMap Class Constructors
 * 1. HashMap();
 * 2. HashMap(int Capacity);
 * 3. HashMap(int Capacity, float LoadFactor);
 * 4. HashMap(Map m);
 */

public class HashMapBasicString {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("1001", "aaaa");
		hashMap.put("1002", "bbbb");
		hashMap.put("1003", "cccc");
		hashMap.put("1004", "dddd");
		//noinspection RedundantStringConstructorCall
		hashMap.put(new String("1005"), "eeee");        //no difference with using new
		hashMap.put("1001", "only changed the value of 1001");      // it'll replace the value at key

		/*
		 * Set set = hashMap.entrySet();
		 * valid but produces raw type variable set
		 * so if we want its iterator to be stores in type specific
		 *         Iterator<Map.Entry> iterator = set.iterator();
		 *         its valid but waring : unchecked type generated
		 *         Note: Recompile with -Xlint:unchecked for details.
		 */

		Set<Map.Entry<String, String>> set = hashMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator = set.iterator();

		//noinspection WhileLoopReplaceableByForEach
		while (iterator.hasNext()) {
			Map.Entry e = iterator.next();

			System.out.println(e.getKey() + " " + e.getValue());
		}

	}
}
/*
 * OUTPUT
 * if you see the entry is shown as a addToBeginningOfLinkedList(), 5->4->3->2->1
 * 1005 eeee
 * 1004 dddd
 * 1003 cccc
 * 1002 bbbb
 * 1001 only changed the value of 1001
 */