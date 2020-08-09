/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.interruption;

import java.io.IOException;

public class SystemInput {

    public static void main(String[] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");

        // has to be set before .start()
        thread.setDaemon(true); // this will let the thread die gracefully

        thread.start();

        thread.interrupt(); // doesn't work as isInterrupted is held by user input
    }

    private static class WaitingForUserInput implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    // depends if by the time this line is read - have we interrupted from main
                    // - so can't rely on isInterrputed with IO
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted forcefully");
                        return;
                    }

                    // ask for user input
                    char input = (char) System.in.read();

                    if (input == 'q') {
                        return;
                    }

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted forcefully");
                        return;
                    }

                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            }
        }
    }
}
