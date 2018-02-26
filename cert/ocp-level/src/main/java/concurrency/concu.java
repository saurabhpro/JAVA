package concurrency;

import java.util.*;
import java.util.concurrent.*;

public class concu {
	public static void main(String[] args) {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		System.out.println(map.get("elephant"));

		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek());
		System.out.println(queue.poll());

		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek());
		System.out.println(deque.pop());

		// concurrent versions of their sorted counterparts, TreeSet and TreeMap
		new ConcurrentSkipListSet();

		try {
			// maintains a doubly linked list between elements and implements a BlockingDeque interface
			BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
			blockingQueue.offer(39);
			blockingQueue.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingQueue.poll());
			System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException ignored) { // Handle interruption
		}

		try {
			System.out.println("\n** BLOCKING DEQUE**\n");
			BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
			blockingDeque.offer(91);
			blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
			blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
			blockingDeque.offer(3, 4, TimeUnit.SECONDS);

			System.out.println(blockingDeque.poll());
			System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
			System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));

		} catch (InterruptedException e) { // Handle interruption
		}

		System.out.println("\n** CopyOnWriteArrayList**\n");
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
		for (Integer item : list) {
			System.out.print(item + " ");
			list.add(9);
		}
		System.out.println();
		// now the newly added values will show up - on a different iterator
		System.out.println("Size: " + list.size() + " " + list);
	}
}
