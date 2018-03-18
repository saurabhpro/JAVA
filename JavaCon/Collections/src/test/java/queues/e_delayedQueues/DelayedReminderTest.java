/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.e_delayedQueues;

import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;

class DelayedReminderTest {

	@Test
	void test() {
		DelayQueue<DelayedReminder> queue = new DelayQueue<>();

		DelayedReminder reminder = new DelayedReminder("Wake me up in 60 seconds", 60);
		queue.add(reminder);

		reminder = new DelayedReminder("Wake me up in 30 seconds", 30);
		queue.add(reminder);

		queue.forEach(System.out::println);

		/*output
		DelayedReminder{reminderText='Wake me up in 30 seconds', delayInSeconds=30}
		DelayedReminder{reminderText='Wake me up in 60 seconds', delayInSeconds=60}
		 */
	}
}