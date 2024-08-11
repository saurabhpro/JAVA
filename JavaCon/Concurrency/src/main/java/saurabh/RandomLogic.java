package saurabh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

public class RandomLogic {

    private static final Logger LOG = LoggerFactory.getLogger(RandomLogic.class);

    public static void main(String[] args) {
        final var threadLocalRandom = new ValueGenerator(ThreadLocalRandom.current());
        final var v1 = rangeClosed(1, 100).mapToObj(threadLocalRandom::nextInt).collect(joining(","));
        LOG.info("Thread Local Random {}", v1);

        final var random = new ValueGenerator(new Random());
        final var v2 = rangeClosed(1, 100).mapToObj(random::nextInt).collect(joining(","));
        LOG.info("Random {}", v2);

        final var customRandom = new ValueGenerator(() -> 0);
        final var v3 = rangeClosed(1, 100).mapToObj(customRandom::nextInt).collect(joining(","));
        LOG.info("Custom Random {}", v3);
    }

    private record ValueGenerator(RandomGenerator generator) {

        public String nextInt(int bound) {
            return String.valueOf(generator.nextInt(bound));
        }
    }
}
