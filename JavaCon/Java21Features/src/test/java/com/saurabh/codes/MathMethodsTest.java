package com.saurabh.codes;

import org.junit.jupiter.api.Test;

import static java.lang.Math.clamp;
import static org.assertj.core.api.Assertions.assertThat;

class MathMethodsTest {

    @Test
    void clamp_value_when_min_max_is_suitable() {
        // given

        // when
        var clamped = clamp(10, 5, 15);

        // then
        assertThat(clamped).isEqualTo(10);
    }

    @Test
    void clamp_value_when_min_max_is_not_fitting() {
        // given

        // when
        var clamped = clamp(16, 5, 15);

        // then
        assertThat(clamped).isEqualTo(15);
    }
}