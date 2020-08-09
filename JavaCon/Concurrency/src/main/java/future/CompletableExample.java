package future;

import java.util.concurrent.*;

public class CompletableExample {

    public static Future<String> calculateAsync() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        final Future<Object> hello = Executors.newCachedThreadPool()
                .submit(() -> {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(500);
                            completableFuture.complete("Hello");
                            return null;
                        }
                );

        System.out.println(hello.get(1000, TimeUnit.MILLISECONDS));
        completableFuture.complete("Just get it done");
        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        final Future<String> stringFuture = calculateAsync();

        System.out.println(stringFuture.get());
    }
}
