/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.util;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class TimeTicker {

	private final BehaviorSubject<Long> tickerSubject;
	private final long interval;

	private volatile boolean paused;
	private long lastTick;
	private Thread tickerThread;

	public TimeTicker(long interval) {

		lastTick = System.currentTimeMillis();
		//BehaviorSubject stores event emitted and onSubscribe onNext, onError, onSuccess
		tickerSubject = BehaviorSubject.createDefault(lastTick);
		tickerThread = null;
		paused = false;
		this.interval = interval;
	}

	public Observable<Long> toObservable() {
		return tickerSubject;
	}

	public synchronized void start() {

		if (tickerThread != null) {
			return; // the ticker thread is already running.
		}

		// make sure to clear the paused flag
		unpause();

		tickerThread = new Thread(() -> {

			try {
				while (!Thread.interrupted()) {

					// Sleep for 5 milliseconds
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// Interrupted...break;
						break;
					}

					// If we are paused then don't send the ticks.
					if (paused)
						continue;

					// Get the current time
					long currentTime = System.currentTimeMillis();
					if (currentTime - lastTick > interval) {
						lastTick = currentTime;
						tickerSubject.onNext(lastTick); // call onNext
					}
				}
			} catch (Throwable t) {
				// Notify all subscribers that there has been an error.
				tickerSubject.onError(t);   // call onError
			}

			// Make sure all subscribers are told that the list is complete
			tickerSubject.onComplete();

		}, "TickerThread");
		tickerThread.start();
	}

	public synchronized void stop() {
		if (tickerThread == null) {
			return; // The ticker thread isn't running.
		}

		tickerThread.interrupt();

		try {
			tickerThread.join();

		} catch (InterruptedException ex) {
			// suppress
		}
		tickerThread = null;
	}

	public void pause() {
		paused = true;
	}

	public void unpause() {
		paused = false;
	}
}
