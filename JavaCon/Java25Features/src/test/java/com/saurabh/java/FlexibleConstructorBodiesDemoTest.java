package com.saurabh.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link FlexibleConstructorBodiesDemo.PositiveAmount} (JEP 513, final in JDK 25).
 *
 * <p>The interesting bit is <em>when</em> the validation runs — before
 * {@code super(...)}. Pre-JDK-25 the same check would have had to live in a static
 * factory or be duplicated inside the parent class.
 */
class FlexibleConstructorBodiesDemoTest {

    @Test
    void valid_amount_is_stored_in_cents_and_currency_is_normalised() {
        // when
        var money = new FlexibleConstructorBodiesDemo.PositiveAmount(150, "usd");

        // then — prologue normalised the lower-case "usd" to "USD" before super()
        assertThat(money.amount()).isEqualTo(150 * 100L);
        assertThat(money.currency()).isEqualTo("USD");
    }

    @Test
    void null_currency_falls_back_to_USD_in_prologue() {
        // when
        var money = new FlexibleConstructorBodiesDemo.PositiveAmount(75, null);

        // then
        assertThat(money.currency()).isEqualTo("USD");
    }

    @Test
    void negative_amount_throws_before_super_runs() {
        // when / then — IllegalArgumentException originates in the prologue;
        // the parent Money constructor is never invoked at all
        assertThatThrownBy(() -> new FlexibleConstructorBodiesDemo.PositiveAmount(-1, "USD"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("amount must be >= 0");
    }
}
