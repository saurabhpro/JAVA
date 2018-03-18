/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.iterators;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class IteratorsForVectors {

	public static void main(String[] args) {
		VectorIterators vectorIterators = new VectorIterators();
		vectorIterators.Iterator();
		vectorIterators.listIterator();
		vectorIterators.enumerationLegacyIter();
	}

	static class VectorIterators implements ListOp {
		final Vector<Integer> list = new Vector<>();
		/*
		cannot use List<Integer> here as elements method isn't there in List base interface,
		so wont be able to use it
		*/
		Enumeration<Integer> enumeration = null;

		VectorIterators() {
			list.add(23);
			list.add(98);
			list.add(29);
			list.add(71);
			list.add(5);
		}


		void listIterator() {
			listIterator(list);
		}

		void Iterator() {
			iterator(list);
		}

		void enumerationLegacyIter() {
			enumeration = list.elements();
			System.out.println("Elements found through Legacy Enumeration (Not-Fail Fast)");
			while (enumeration.hasMoreElements())
				System.out.print(enumeration.nextElement() + " ");
		}
	}

}
