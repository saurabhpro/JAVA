package com.saurabh.java;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StructuredConcurrencyDemo} (JEP 505, preview through JDK 26).
 *
 * <p>Two subtasks each sleep 50 ms. If they ran sequentially the call would take
 * ~100 ms; in a structured task scope they run on virtual threads in parallel, so
 * the total should be much closer to a single sleep.
 */
class StructuredConcurrencyDemoTest {

    @Test
    void parallel_forks_aggregate_into_combined_result() throws Exception {
        // when
        var result = StructuredConcurrencyDemo.fetchInParallel("alice");

        // then
        assertThat(result).isEqualTo("profile:alice | orders:alice");
    }

    @Test
    void forks_run_concurrently_not_sequentially() throws Exception {
        // given
        var start = Instant.now();

        // when
        StructuredConcurrencyDemo.fetchInParallel("bob");

        // then — two 50ms subtasks in parallel finish well under their 100ms sequential sum
        var elapsed = Duration.between(start, Instant.now());
        assertThat(elapsed).isLessThan(Duration.ofMillis(95));
    }
}
