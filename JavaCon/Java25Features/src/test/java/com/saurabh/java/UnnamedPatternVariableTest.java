package com.saurabh.java;

import org.junit.jupiter.api.Test;

import static com.saurabh.java.UnnamedPatternVariable.getObjectsColorWithSwitchAndUnnamedPattern;
import static com.saurabh.java.UnnamedPatternVariable.getObjectsColorWithUnnamedPattern;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UnnamedPatternVariable} — JEP 456, final in JDK 22. The
 * underscore stands in for components we don't care about, so a {@code Car}
 * record with three fields can be destructured to grab only the colour.
 */
class UnnamedPatternVariableTest {

    @Test
    void if_pattern_extracts_color_and_ignores_other_record_components() {
        // given
        var car = new UnnamedPatternVariable.Car("tesla");

        // when
        var color = getObjectsColorWithUnnamedPattern(car);

        // then — Car("tesla") uses the secondary constructor → "Red" / "100k"
        assertThat(color).isEqualTo("Red");
    }

    @Test
    void if_pattern_returns_fallback_for_non_Car_object() {
        // when
        var color = getObjectsColorWithUnnamedPattern("not a car");

        // then
        assertThat(color).isEqualTo("No color!");
    }

    @Test
    void switch_pattern_extracts_color_for_Car() {
        // given
        var car = new UnnamedPatternVariable.Car("yaris", "Blue", "20k");

        // when
        var color = getObjectsColorWithSwitchAndUnnamedPattern(car);

        // then
        assertThat(color).isEqualTo("Blue");
    }

    @Test
    void switch_pattern_falls_through_to_default_for_non_Car() {
        // when
        var color = getObjectsColorWithSwitchAndUnnamedPattern(42);

        // then
        assertThat(color).isEqualTo("No color!");
    }
}
