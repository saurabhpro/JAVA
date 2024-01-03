package map;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Map.entry;
import static map.MapMerge.countWordOccurrencesWithCollect;
import static org.assertj.core.api.Assertions.assertThat;

class MapMergeTest {

    @Test
    void count_word_occurrence_without_map_merge() {
        // given

        var words = List.of("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");

        // when
        var actual = countWordOccurrencesWithCollect(words);

        // then
        assertThat(actual).contains(
            entry("Bar", 1),
            entry("Buzz", 2),
            entry("Fizz", 2),
            entry("Foo", 3)
        );
    }
}