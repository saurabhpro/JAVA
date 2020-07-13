/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package resoucemanagment;

import java.lang.ref.Cleaner;

/**
 * ##EFFECTIVE_JAVA
 * The static nested State class holds the resources that are required by the cleaner to clean the room.
 * In this case, it is simply the numJunkPiles field, which represents the amount of mess in the room.
 * <p>
 * More realistically, it might be a final long that contains a pointer to a native peer.
 * State implements Runnable, and its run method is called at most once,
 * by the Cleanable that we get when we register our State instance with our cleaner in the Room constructor.
 * The call to the run method will be triggered by one of two things:
 * <li>Usually it is triggered by a call to Room’s close method calling Cleanable’s clean method.</li>
 * <li>If the client fails to call the close method by the time a Room instance is eligible for garbage collection, the cleaner will (hopefully) call State’s run method.</li>
 * <p>
 * It is critical that a State instance does not refer to its Room instance.
 * If it did, it would create a circularity that would prevent the Room instance from becoming eligible for garbage collection (and from being automatically cleaned).
 * Therefore, State must be a static nested class because nonstatic nested classes contain references to their enclosing instances (Item 24).
 * It is similarly inadvisable to use a lambda because they can easily capture references to enclosing objects.
 */
// An autocloseable class using a cleaner as a safety net
class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();
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
            numJunkPiles = 0;   // instead of this the object can be passed here for cleanup
        }
    }
}

public class RoomCl {
    public static void main(String[] args) {
        // GOOD APPROACH - use AUTO-CLOASABLE
        try (Room room = new Room(5)) {
            System.out.println("Goodbye");
        }

        // BAD APPROACH - might use CLEANER.Clean()
        Room room =  new Room(99);
        System.out.println("Peace out");
    }
}