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

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Insert {
	static boolean isEmpty(Node head) {
		return head == null;
	}

	public Node insertAtBeg(int num, Node head) {
		Node temp = new Node(num, null);

		if (isEmpty(head))
			head = temp;
		else {
			temp.next = head;
			head = temp;
		}
		return head;
	}

	public Node insertAtEnd(int num, Node head) {
		Node temp = new Node(num);
		Node p = head;

		if (isEmpty(head))
			head = temp;

		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;

		return head;
	}

	public Node insert(int num, Node head, int pos) {
		Node temp = new Node(num);

		if (isEmpty(head))
			head = temp;
		else if (pos == 0) {
			temp.next = head;
			head = temp;
		} else {
			int counter = 0;
			Node p = head;
			while (counter++ < pos - 1 && p != null)
				p = p.next;


			if (p != null) {
				temp.next = p.next;
				p.next = temp;
			}
		}
		return head;
	}
}
