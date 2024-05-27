package virtual;

import java.util.concurrent.Executors;

public class a_StartVirtual {

    public static void main(String[] args) throws InterruptedException {
        thread();

        runnable();

        executorService();

        unstart();
    }

    private static void thread() throws InterruptedException {
        final var thread = Thread.ofVirtual()
            .start(() -> System.out.println("Hello"));

        thread.join();
    }

    private static void runnable() {
        final Runnable task = () -> System.out.println("Hello Virtual Thread!");
        Thread.startVirtualThread(task);
    }

    private static void executorService() {
        final var executorService = Executors.newVirtualThreadPerTaskExecutor();

        // Submit tasks to the executor service
        executorService.submit(
            () -> System.out.println("Task 1 is running on virtual thread: " + Thread.currentThread().getName()));

        // Shutdown the executor service
        executorService.shutdown();
    }

    private static void unstart() throws InterruptedException {
        final var virtualThread = Thread.ofVirtual()
            .unstarted(() -> System.out.println("Virtual thread is running"));

        // Start the virtual thread
        virtualThread.start();

        // Wait for the virtual thread to finish
        virtualThread.join();

    }

}
