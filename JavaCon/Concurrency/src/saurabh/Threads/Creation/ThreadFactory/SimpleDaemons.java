package saurabh.Threads.Creation.ThreadFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Saurabh on 10/21/2015. A Daemon Thread is intended to provide general services in the background as long
 * as the program is running When all User (non-daemon) threads completes, the program terminates killing all (even
 * alive) non-daemon threads But if any user thread is running , the program doesn't terminate
 * <p>
 * To create a Daemon thread simply call setDaemon(boolean) method of Thread Class
 */

public class SimpleDaemons implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread threadDaemon = new Thread(new SimpleDaemons());
            threadDaemon.setDaemon(true);   //must be called before start()


            threadDaemon.start();

            System.out.println(threadDaemon.isDaemon());
        }
        System.out.println("All Daemons started");
        TimeUnit.MILLISECONDS.sleep(250);       //change the sleep time to see the behavior of daemon threads
        // (<200 only 5 lines of output) coz run() sleeps of 100

    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
}