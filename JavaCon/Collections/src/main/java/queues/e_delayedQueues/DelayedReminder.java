/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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

	public long getDelay(TimeUnit timeUnit) {
		return TimeUnit.SECONDS.convert(delayInSeconds, timeUnit);
	}

	public int compareTo(Delayed delayed) {
		return (int) (delayInSeconds - delayed.getDelay(TimeUnit.SECONDS));
	}
}