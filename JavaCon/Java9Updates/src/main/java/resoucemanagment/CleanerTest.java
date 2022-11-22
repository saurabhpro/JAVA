package resoucemanagment;

import java.lang.ref.Cleaner;

/**
 * In Java 9, the finalize() method has been deprecated and a new class java.lang.ref.Cleaner added to garbage collection management.
 * An object of Cleaner class gets notified automatically when an object becomes eligible for garbage collection.
 * An object that is being garbage collected needs to be registered with the cleaner object by using the register() method.
 */
public class CleanerTest {

    public static void main(String args[]) {
        System.out.println("TutorialsPoint");
        Cleaner cleaner = Cleaner.create();
        if (true) {
            CleanerTest myObject = new CleanerTest();
            cleaner.register(myObject, new State());    // register cleaner
        }
        for (int i = 1; i <= 10000; i++) {
            String[] largeObject = new String[1000];
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class State implements Runnable {

        public void run() {
            System.out.print("Cleaning action");
        }
    }
}