/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.util;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

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
