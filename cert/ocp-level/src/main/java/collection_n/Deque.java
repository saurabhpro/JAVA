package collection_n;

import java.util.ArrayDeque;
import java.util.Queue;

public class Deque {
	public static void main(String[] args) {

		System.out.println("Queue");
		// Deque as queue Offer/poll/peek FIFO
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10));
		System.out.println(queue.offer(4)); // offer at end + false if not added
		System.out.println(queue.peek());
		System.out.println(queue.poll());   // poll from top + null if empty
		System.out.println(queue.poll());
		System.out.println(queue.peek());   // peek(don't remove) from top + null if empty


		System.out.println("\nStack");
		// Deque as Stack push/poll/peek LIFO
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10); // void push(...)   // push at top + exception if el = null
		stack.push(4);
		System.out.println(stack.element());    // get(not remove) First + exception if empty
		System.out.println(stack.peek());
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		System.out.println(stack.peek());

		ArrayDeque<String> greetings = new ArrayDeque<String>();
		greetings.push("hello");
		greetings.push("hi");
		greetings.push("ola");
		greetings.pop();
		greetings.peek();
		while (greetings.peek() != null)
			System.out.print(greetings.pop());  // exception if empty

	}
}
