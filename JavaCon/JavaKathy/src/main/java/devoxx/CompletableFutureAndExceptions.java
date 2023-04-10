package devoxx;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureAndExceptions {

    public static String getNameOfAirport(String iata) throws IOException {
        final var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

        try (final var scanner = new Scanner(new URL(url).openStream())) {
            final var response = scanner.nextLine();

            if (!response.contains("Name")) {
                throw new RuntimeException("Invalid airport code " + iata);
            }

            return response.split("\"")[3];
            //way too lazy to do the real work to get the data
        }
    }

    public static int compute() {
        return 2;
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static int transform(int number, int multiplier) {
        System.out.println("transform called...");

        if (Math.random() > 0.5) {
            System.out.println("transform failed...");
            throw new RuntimeException("something went wrong");
        }

        return number * multiplier;
    }

    public static void main(String[] args) {
        create()
            .thenApply(data -> transform(data, 10))
            .exceptionally(throwable -> handleException(throwable))
            .thenApply(data -> transform(data, 2))
            .exceptionally(throwable1 -> handleException(throwable1))
            .thenAccept(System.out::println);
    }

    public static int handleException(Throwable throwable) {
        System.out.println("handling exception..." + throwable.getMessage());
        return 100;
    }
}

/*
Promises or CompletableFuture

States:
-pending
-resolved (terminal)
-rejected (terminal)

   =======X=========X=============================X=====
d -> f -> P -> f -> P -> f -> P -> f -> P -> f -> P
   ===========================E=========E===============

X - data
E - error

Stream may have 0, 1, or any number of data

CompletableFuture may have 0 or 1 piece of data

CompletableFuture  Function  next?

CompletableFuture  Function  next?
  resolved            ✓      go to the next then
  resolved            x      go to the next exceptionally
  rejected            ✓      go to the next then
  rejected            x      go to the next exceptionally
*/

class Sample {

    public static String getNameOfAirport(String iata) {
        try {
            final var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

            try (final var scanner = new Scanner(new URL(url).openStream())) {
                final var response = scanner.nextLine();

                if (!response.contains("Name")) {
                    throw new RuntimeException("Invalid airport code " + iata);
                }

                return response.split("\"")[3];
                //way too lazy to do the real work to get the data
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static CompletableFuture<Void> processIATA(String iataCode) {
        return CompletableFuture.supplyAsync(() -> getNameOfAirport(iataCode))
            .thenApply(String::toUpperCase)
            .exceptionally(throwable -> throwable.getMessage())
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        final var iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

        final var tasks = iataCodes.stream()
            .map(Sample::processIATA)
            .toList();

        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
        }
    }
}

//A bit better with a good separation of concern for each function
//then... focuses on data
//exceptionally focuses on error
//
//But, we still have to deal with a mixture of data handling and error
//handling in different stages of the pipeline.
