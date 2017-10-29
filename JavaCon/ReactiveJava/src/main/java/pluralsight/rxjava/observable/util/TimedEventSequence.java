/*
 * Copyright 2017 Saurabh Kumar 29/10/17 7:17 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.util;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class TimedEventSequence<T> {

	private final PublishSubject<T> subject;
	private final ArrayList<T> eventData;
	private final long intervalMs;

	private int offset;
	private long lastTick;
	private Thread tickThread;
	private volatile boolean paused = false;

	public TimedEventSequence(List<T> eventData, long intervalMs) {
		this.eventData = new ArrayList<T>(eventData);
		this.intervalMs = intervalMs;
		this.offset = 0;
		this.subject = PublishSubject.create();
		this.tickThread = null;
	}

	public synchronized void start() {

		if (tickThread != null) {
			return; // No active thread.
		}

		lastTick = System.currentTimeMillis();

		paused = false;

		tickThread = new Thread(() -> {

			try {
				while (!Thread.interrupted()) {
					Thread.sleep(5);

					// If we are paused then don't send the ticks.
					if (paused) {
						continue;
					}

					// Get the current time
					long currentTime = System.currentTimeMillis();
					if (currentTime - lastTick > intervalMs) {
						lastTick = currentTime;
						subject.onNext(nextEvent());
					}
				}
			} catch (InterruptedException e) {
				// suppress
			} catch (Throwable t) {
				// Notify all subscribers that there has been an error.
				subject.onError(t);
			}

			// Make sure all subscribers are told that the list is complete
			subject.onComplete();

		}, "TimedEventSequence Thread");
		tickThread.start();
	}

	public synchronized void stop() {
		if (tickThread == null) {
			return; // The ticker thread isn't running.
		}

		tickThread.interrupt();
		try {
			tickThread.join();
		} catch (InterruptedException ex) {
			// suppress
		}
		tickThread = null;
	}

	public void pause() {
		paused = true;
	}

	public void unpause() {
		paused = false;
	}

	private synchronized T nextEvent() {

		if (eventData == null) {
			return null;
		}

		int size = eventData.size();
		if (size == 0) {
			return null;
		}

		if (offset >= eventData.size()) {
			offset = 0;
		}

		return eventData.get(offset++);

	}

	public Observable<T> toObservable() {
		return subject;
	}

}
