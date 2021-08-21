package saurabh.deadlock.detection;

import java.util.concurrent.locks.Lock;

public class Runnable2DeadlockDetection implements Runnable {

    private LockGraphFacade lockGraphFacade = null;
    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable2DeadlockDetection(LockGraphFacade lockGraphFacade, Lock lock1, Lock lock2) {
        this.lockGraphFacade = lockGraphFacade;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        while (true) {
            int failureCount = 0;
            while (!tryLockBothLocks()) {
                failureCount++;
                System.err.println(threadName + " failed to lock both Locks. " +
                        "Waiting a bit before retrying [" + failureCount + " tries]");
                sleep(100L * ((long) Math.random()));
            }
            if (failureCount > 0) {
                System.out.println(threadName +
                        " succeeded in locking both locks - after " + failureCount + " failures.");
            }

            //do the work - now that both locks have been acquired (locked by this thread)

            //unlock
            this.lockGraphFacade.unlock(this.lock2);
            this.lockGraphFacade.unlock(this.lock1);
        }
    }

    private void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryLockBothLocks() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " lock2: attempt lock");
        boolean lock2Succeeded = this.lockGraphFacade.tryLock(this.lock2);
        if (!lock2Succeeded) {
            return false;
        }
        System.out.println(threadName + " lock2: locked");

        sleep(1000);

        System.out.println(threadName + " lock1: attempt lock");
        boolean lock1Succeeded = this.lockGraphFacade.tryLock(this.lock1);
        if (!lock1Succeeded) {
            this.lockGraphFacade.unlock(lock2);
            return false;
        }
        System.out.println(threadName + " lock1: locked");

        return true;
    }
}
