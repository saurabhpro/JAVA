/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.interruption;

import udemy.util.BigIntPow;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class ThreadInterruption {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new BlockingThread(BigInteger.valueOf(2000L), BigInteger.valueOf(100000L)));

        thread1.start();
        thread1.setName(BlockingThread.class.getSimpleName());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // finally interrupt the running thread after 5 seconds of wait
        thread1.interrupt();
    }

    /**
     * Class that performs power function on big integers
     */
    private static class BlockingThread implements Runnable {
        private final BigInteger base;
        private final BigInteger power;

        public BlockingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.printf("Result of %s^%s = %s", base, power, BigIntPow.pow(base, power));
        }
    }

}
