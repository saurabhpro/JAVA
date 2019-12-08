/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package resoucemanagment;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net
class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;

    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        // Registers an object and a cleaning action to run when the object becomes phantom reachable.
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}

public class RoomCl {
    public static void main(String[] args) {
        try (Room room = new Room(5)) {
        }
    }
}