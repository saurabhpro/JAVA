package com.saurabh.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link PrimitivePatternsDemo} (JEP 507, preview through JDK 26).
 */
class PrimitivePatternsDemoTest {

    @Test
    void switch_distinguishes_negative_int_branch_via_guard() {
        assertThat(PrimitivePatternsDemo.describe(-1)).isEqualTo("negative int -1");
    }

    @Test
    void switch_matches_int_pattern_for_positive_Integer() {
        assertThat(PrimitivePatternsDemo.describe(42)).isEqualTo("non-negative int 42");
    }

    @Test
    void switch_matches_long_pattern_for_Long_input() {
        assertThat(PrimitivePatternsDemo.describe(200_000L)).isEqualTo("long 200000");
    }

    @Test
    void switch_matches_double_pattern_for_Double_input() {
        assertThat(PrimitivePatternsDemo.describe(3.14)).isEqualTo("double 3.14");
    }

    @Test
    void switch_handles_null_via_explicit_case() {
        assertThat(PrimitivePatternsDemo.describe(null)).isEqualTo("null");
    }

    @Test
    void switch_falls_through_to_default_for_String() {
        assertThat(PrimitivePatternsDemo.describe("hello")).isEqualTo("other (String)");
    }

    @Test
    void instanceof_int_pattern_unboxes_Integer() {
        assertThat(PrimitivePatternsDemo.unbox(7)).isEqualTo(7);
    }

    @Test
    void instanceof_int_pattern_rejects_non_int_input() {
        assertThatThrownBy(() -> PrimitivePatternsDemo.unbox("nope"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not an int");
    }
}
