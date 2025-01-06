package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * https://cr.openjdk.org/~vklang/Gatherers.html
 * https://www.infoworld.com/article/2510405/stream-gatherers-a-new-way-to-manipulate-java-streams-2.html
 */
@SuppressWarnings({"java:S3655", "java:S2629", "all"})
public class StreamGatherers22 {

    private static final Logger LOG = LoggerFactory.getLogger(StreamGatherers22.class);

    public static void main(String[] args) {

        final var numbers = asList(1, 2, 3, 4, 5, 6);
        LOG.info("{}", Arrays.toString(numbers.stream().filter(number -> number % 2 == 0).toArray())); // result: { 2, 4, 6 }

        // windowFixed method is a simpler way to gather your windowed elements into buckets
        LOG.info(
            "\nGather WindowFixed\n{}", Stream.iterate(0, i -> i + 1)
                .gather(Gatherers.windowFixed(2))
                .limit(5)
                .toList()
        );

        // Scan is something like windowFixed but it accumulates the elements into a single element instead of an array
        LOG.info(
            "\nGather Scan\n{}", Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(
                    Gatherers.scan(() -> "", (string, number) -> string + number)
                )
                .toList()
        );

        //  windowSliding works like windowFixed() except each window starts on the next element in the source array
        LOG.info(
            "\nGather WindowSliding\n{}", Stream.iterate(0, i -> i + 1)
                .gather(Gatherers.windowSliding(2))
                .limit(5)
                .toList()
        );

        // Folding is a generalization of reduction. With reduction, the result type is the same as the element type, the combiner is associative,
        // and the initial value is an identity for the combiner. For a fold, these conditions are not required, though we give up parallelizability.
        LOG.info(
            "\nGather fold\n{}\nStream Reduce\n{}", Stream.of("hello", "world", "how", "are", "you?")
                .gather(
                    Gatherers.fold(
                        () -> "",
                        (acc, element) -> acc.isEmpty() ? element : acc + "," + element
                    )
                )
                .findFirst()
                .orElseThrow(),
            Stream.of("hello", "world", "how", "are", "you?")
                .reduce("", (acc, element) -> acc.isEmpty() ? element : acc + "," + element)
        );

        //  mapConcurrent can specify a maximum number of threads to use concurrently in running the map function provided. Virtual threads will be used.
        LOG.info(
            "\nGather MapConcurrent\n{}", Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.mapConcurrent(4, x -> x * x)).toList()
        );

    }

}
