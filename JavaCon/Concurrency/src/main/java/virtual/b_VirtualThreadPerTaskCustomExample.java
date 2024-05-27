package virtual;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * The method Executors.newThreadPerTaskExecutor(ThreadFactory) doesn't create virtual threads directly.
 * Instead, it enables you to use a custom ThreadFactory to control how threads are created.
 * To mimic virtual threads, implement the ThreadFactory interface to generate threads with names
 * indicating their virtual nature.
 */
public class b_VirtualThreadPerTaskCustomExample {

    public static void main(String[] args) {
        // Create a custom thread factory for virtual threads
        final ThreadFactory customThreadFactory = new VirtualThreadFactory();
        // Create an executor service using the custom thread factory
        final var executorService = Executors.newThreadPerTaskExecutor(customThreadFactory);
        // Submit tasks to the executor service
        executorService.submit(
            () -> System.out.println("Task 1 is running on virtual thread: " + Thread.currentThread().getName()));
        // Shutdown the executor service
        executorService.shutdown();
    }

    // Custom thread factory to create virtual threads
    static class VirtualThreadFactory implements ThreadFactory {

        private int count = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "VirtualThread-" + count++);
        }
    }
}
