/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */
public class IteratorsForArrayList {

	public static void main(String[] args) {
		ListIterators listIterators = new ListIterators();
		listIterators.Iterator();
		listIterators.listIterator();

	}

	static class ListIterators implements ListOp {
		final List<Integer> list = new ArrayList<>();

		ListIterators() {
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
	}

}
