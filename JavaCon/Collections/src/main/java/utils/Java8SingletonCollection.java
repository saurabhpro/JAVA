/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package utils;

import java.util.*;

/**
 * Created by Saurabh on 2/28/2016.
 */
public class Java8SingletonCollection {

	public static void main(String[] args) {
		List<Integer> list = Collections.singletonList(45);
		Set<Integer> set = Collections.singleton(46);
		Map<Integer, String> map = Collections.singletonMap(47, "Hey");

		list.forEach(System.out::println);
		set.forEach(System.out::println);


		//expanded
		SingletonListEx.test1();

	}

	static class SingletonListEx {
		/*
			 A singleton list contains only one element and a singleton HashMap includes only one key.
			 A singleton object is immutable (cannot be modified to add one more element); avoids usage of add().

			To obtain a singleton class from a general collection class, singletonList() method of Collections is used.

			Following is the method signature
			1. List singletonList(Object obj1): Returns an immutable list containing only one element obj1.
			The element obj1 cannot be removed or added with no further elements. Introduced with JDK 1.3.
			******************************************************************************************************

			Collections.singletonList(something) is immutable whereas Arrays.asList(something) is a
			fixed size List representation of an Array where the List and Array gets joined in the heap.

			Arrays.asList(something) allows non-structural changes made to it, which gets reflected to both
			the List and the conjoined array. It throws UnsupportedOperationException for adding, removing elements
			although "you can set an element for a particular index."

			Any changes made to the List returned by Collections.singletonList(something) will
			always result in UnsupportedOperationException.

			Also, the capacity of the List object returned by Collections.singletonList(something) will always be 1
			unlike Arrays.asList(something) whose capacity will be the size of elements in the backed array.
		*/

		static void test1() {
			// create an array of string objs
			String init[] = {"One", "Two", "Three"};

			// create one list
			List list = Arrays.asList(init);        //returns obj of type Iterable - not castable to ArrayList
			//List value before: [One, Two, Three, One, Two, Three]

			//testing if we can separately access each string in list - YES
			list.forEach(System.out::println);

			//list.add(2,'K');  - - throws java.lang.UnsupportedOperationException
			list.set(2, "K"); //- allowed

			System.out.println("List value before: " + list);


			// create singleton list
			list = Collections.singletonList(list);
			//list.add(2,'t'); - throws java.lang.UnsupportedOperationException
			//list.set(0,"K");
			System.out.println("List value after: " + list);
			//List value after: [[One, Two, Three, One, Two, Three]]
			//list cannot be tampered as it is only one object and also immutable

			//testing if we can separately access each string in list - NO
			list.forEach(System.out::println);

		}
	}
}
