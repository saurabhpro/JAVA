/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.util;

public class ThreadUtils {

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
            // suppress
        }
    }

    public static void wait(Object monitor) {
        try {
            // Assumes that the monitor is already "synchronized"
            monitor.wait();
        } catch (InterruptedException ignored) {
            // suppress
        }
    }

    public static String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
