package Ch03_Stacks_and_Queues.Q3_04_Queue_via_Stacks;

import java.util.Stack;

class MyQueue<T> {
	private final Stack<T> stackNewest;
	private final Stack<T> stackOldest;

	public MyQueue() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		// Push onto stack1
		stackNewest.push(value);
	}

	/* Move elements from stackNewest into stackOldest. This is usually done so that we can
	 * do operations on stackOldest.
	 */
	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek(); // retrieve the oldest item.
	}

	public T remove() {
		shiftStacks();
		return stackOldest.pop(); // pop the oldest item.
	}
}