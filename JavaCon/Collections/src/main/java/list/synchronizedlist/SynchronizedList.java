/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.synchronizedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class SynchronizedList {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<>());

		//Adding some elements to the list
		list.add("Pen");
		list.add("Notebook");
		list.add("Ink");

		System.out.println("Iterating synchronized list");

		synchronized (list) {

			/*while (iterator.hasNext())
				System.out.println(iterator.next() + " ");		}
				*/

			for (String aList : list) System.out.println(aList + " ");
		}


	}
}
