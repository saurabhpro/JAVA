package Ch15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB;

import CtCILibrary.AssortedMethods;

class Philosopher extends Thread {
    private final int maxPause = 100;
    private final int bites = 10;

    private final Chopstick lower;
    private final Chopstick higher;
    private final int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    private void eat() {
        System.out.println("Philosopher " + index + ": start eating");
        pickUp();
        chew();
        putDown();
        System.out.println("Philosopher " + index + ": done eating");
    }

    private void pickUp() {
        pause();
        lower.pickUp();
        pause();
        higher.pickUp();
        pause();
    }

    private void chew() {
        System.out.println("Philosopher " + index + ": eating");
        pause();
    }

    private void pause() {
        try {
            int pause = AssortedMethods.randomIntInRange(0, maxPause);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void putDown() {
        higher.putDown();
        lower.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
