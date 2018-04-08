/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.e_delayedQueues;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedReminder implements Delayed {
	private String reminderText;
	private long delayInSeconds;

	public DelayedReminder(String reminder, long seconds) {
		reminderText = reminder;
		delayInSeconds = seconds;
	}

	@Override
	public String toString() {
		return "DelayedReminder{" +
				"reminderText='" + reminderText + '\'' +
				", delayInSeconds=" + delayInSeconds +
				'}';
	}

	public String getReminderText() {
		return reminderText;
	}

	@Override
	public long getDelay(TimeUnit timeUnit) {
		return TimeUnit.SECONDS.convert(delayInSeconds, timeUnit);
	}

	@Override
	public int compareTo(Delayed delayed) {
		return (int) (delayInSeconds - delayed.getDelay(TimeUnit.SECONDS));
	}
}