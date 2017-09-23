/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package mylist;

import static mylist.Insert.isEmpty;

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Delete {
	public Node delete(Node head, int pos) {
		Node p = head;
		if (isEmpty(p)) {
			return null;
		} else if (p.next == null && pos == 0) {
			head = null;      //elgible for garbage collection
		} else {
			if (pos == 0) {
				head = p.next;
				p = null;
			} else {
				int counter = 0;
				Node prev = null;
				while (counter++ < pos - 1 && p != null) {
					prev = p;
					p = p.next;
				}
				if (p != null) {
					prev.next = p.next;
					p = null;
				}
			}
		}
		return head;
	}
}
