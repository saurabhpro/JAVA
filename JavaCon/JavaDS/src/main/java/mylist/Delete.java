/*
 * Copyright (c) 2018 Saurabh Kumar
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
