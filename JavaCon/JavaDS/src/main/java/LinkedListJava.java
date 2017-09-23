/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import mylist.Delete;
import mylist.Display;
import mylist.Insert;
import mylist.Node;

/**
 * Created by Saurabh on 8/26/2015.
 */
public class LinkedListJava {
	private static Node head;
	private final Node tail;

	LinkedListJava() {
		head = tail = null;
	}

	private static Node insert(Node head) {
		Insert list = new Insert();

		head = list.insertAtBeg(8, head);
		head = list.insertAtBeg(7, head);
		head = list.insertAtBeg(9, head);
		head = list.insertAtBeg(2, head);
		head = list.insertAtEnd(-77, head);

		Display.display(head);
		System.out.println();
		head = list.insert(5, head, 2);
		Display.display(head);
		System.out.println();
		head = list.insert(6, head, 0);
		Display.display(head);
		System.out.println();
		head = list.insert(11, head, 7);

		return head;
	}

	private static Node delete(Node head) {
		Delete list = new Delete();

		System.out.println();
		head = list.delete(head, 2);
		Display.display(head);
		System.out.println();
		head = list.delete(head, 0);
		Display.display(head);
		System.out.println();
		head = list.delete(head, 6);
		return head;
	}

	public static void main(String[] args) {
		head = insert(head);

		Display.display(head);

		head = delete(head);

		Display.display(head);

	}
}

