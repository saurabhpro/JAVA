package virtual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;

// https://www.zymr.com/blog/threads-and-virtual-threads-demystifying-the-world-of-concurrency-in-modern-times
public class c_VirtualThreadURLFetcher {

    public static void main(String[] args) {
        // List of URLs to fetch
        final var urls = Stream.of("https://example.com", "https://www.openai.com", "https://www.google.com")
            .map(URI::create)
            .toList();

        // Fetch contents of URLs concurrently using virtual threads
        fetchURLContentsConcurrently(urls);
    }

    // Fetch contents of URLs concurrently using virtual threads
    public static void fetchURLContentsConcurrently(List<URI> urls) {
        // Create a virtual thread executor service
        final var executorService = Executors.newThreadPerTaskExecutor(new VirtualThreadFactory());

        // Submit tasks to fetch URL contents
        for (final var url : urls) {
            executorService.submit(() -> {
                try {
                    // Fetch URL contents
                    final var content = fetchURL(url);
                    System.out.println("Fetched content from " + url + ":\n" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        // Shutdown the executor service
        executorService.shutdown();
        try {
            // Wait for all tasks to complete or timeout after 10 seconds
            executorService.awaitTermination(10, SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Fetch content of a URL
    public static String fetchURL(URI uri) throws IOException {
        final var url = uri.toURL();
        final var content = new StringBuilder();
        try (final var reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Custom thread factory to provide names for virtual threads
    static class VirtualThreadFactory implements ThreadFactory {

        private int count = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "VirtualThread-" + count++);
        }
    }
}