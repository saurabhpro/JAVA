/*
 * Copyright (c) 2018 Saurabh Kumar
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

