/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package mylist;

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Display {
	public static void display(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print(p.getData() + " ");
			p = p.next;
		}
	}
}
