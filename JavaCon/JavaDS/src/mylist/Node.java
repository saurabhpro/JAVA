package mylist;

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Node {

	protected Node next;
	private int info;

	Node(int num) {
		info = num;
		next = null;
	}

	Node(int a, Node b) {
		info = a;
		next = b;
	}

	public int getData() {
		return info;
	}
}
