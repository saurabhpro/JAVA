package mylist;

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Node {

	private final int info;
	Node next;

	Node(int num) {
		info = num;
		next = null;
	}

	Node(int a, Node b) {
		info = a;
		next = b;
	}

	int getData() {
		return info;
	}
}
