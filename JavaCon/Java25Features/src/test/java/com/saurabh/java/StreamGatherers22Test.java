package com.saurabh.java;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the gatherers used in {@link StreamGatherers22} (JEP 485, final in JDK 24).
 *
 * <p>Each test pins one built-in gatherer's output. They double as a quick reference
 * for what each operator produces.
 */
class StreamGatherers22Test {

    @Test
    void windowFixed_chunks_stream_into_non_overlapping_windows() {
        // when
        var windows = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .gather(Gatherers.windowFixed(3))
                .toList();

        // then — partial trailing window is kept
        assertThat(windows).containsExactly(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7)
        );
    }

    @Test
    void windowSliding_emits_overlapping_windows_advancing_by_one_element() {
        // when
        var windows = Stream.of(1, 2, 3, 4)
                .gather(Gatherers.windowSliding(2))
                .toList();

        // then
        assertThat(windows).containsExactly(
                List.of(1, 2),
                List.of(2, 3),
                List.of(3, 4)
        );
    }

    @Test
    void scan_produces_running_accumulation() {
        // when
        var running = Stream.of(1, 2, 3, 4)
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();

        // then — each element is the running sum
        assertThat(running).containsExactly(1, 3, 6, 10);
    }

    @Test
    void fold_collapses_stream_into_single_terminal_value() {
        // when
        var folded = Stream.of("a", "b", "c")
                .gather(Gatherers.fold(() -> "", (acc, s) -> acc.isEmpty() ? s : acc + "," + s))
                .findFirst()
                .orElseThrow();

        // then — fold yields exactly one element (the final accumulator)
        assertThat(folded).isEqualTo("a,b,c");
    }

    @Test
    void mapConcurrent_preserves_input_order_in_output() {
        // when
        var squares = Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.mapConcurrent(4, x -> x * x))
                .toList();

        // then — mapConcurrent runs in parallel but preserves source order
        assertThat(squares).containsExactly(1, 4, 9, 16, 25);
    }
}
