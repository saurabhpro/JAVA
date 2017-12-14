package collection_n;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * a special queue (say, to pay a utility bill) where a customer can be added only at the end of the queue
 * and can be removed either at the front of the queue (when the customer paid the bill)
 * or from the end of the queue (when the customer gets frustrated from the long line and leaves the queue himself )
 * <p>
 * the difference between an ArrayList and ArrayDeque is that you can add an element anywhere in an array list using an index;
 * however, you can add an element only either at the front or end of the array deque.
 * that makes insertion in array deque more efficient than array list; however, navigation in an array deque
 * becomes more expensive than in an array list.
 */
class SplQueue {
	private Deque<String> splQ = new ArrayDeque<>();
	private Deque<String> splQ1 = new LinkedList<>();
	private Deque<String> splQ2 = new LinkedBlockingDeque<>();

	void addInQueue(String customer) {
		splQ.addLast(customer);
	}

	void removeFront() {
		splQ.removeFirst();
	}

	void removeBack() {
		splQ.removeLast();
	}

	void printQueue() {
		System.out.println("Special queue contains: " + splQ);
	}
}

class SplQueueTest {
	public static void main(String[] args) {
		SplQueue splQ = new SplQueue();
		splQ.addInQueue("Harrison");
		splQ.addInQueue("McCartney");
		splQ.addInQueue("Starr");
		splQ.addInQueue("Lennon");
		splQ.printQueue();
		splQ.removeFront();
		splQ.removeBack();
		splQ.printQueue();
	}
}