package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JEP 513 — Flexible Constructor Bodies (final in JDK 25).
 *
 * <p>Pre-Java-25 the very first statement of a constructor had to be {@code super(...)}
 * or {@code this(...)}. That made it awkward to validate / transform arguments before
 * forwarding them, often forcing static helpers like {@code requireValid(x)}.
 *
 * <p>JEP 513 lets the constructor run a "prologue" — any statements that don't reference
 * {@code this} — before the explicit constructor invocation. After the {@code super(...)}
 * call you're in the "epilogue" and {@code this} is fully usable.
 */
public class FlexibleConstructorBodiesDemo {

    private static final Logger LOG = LoggerFactory.getLogger(FlexibleConstructorBodiesDemo.class);

    public static void main(String[] args) {
        var p = new PositiveAmount(150, "USD");
        LOG.info("amount={} currency={}", p.amount(), p.currency());

        try {
            new PositiveAmount(-1, "USD");
        } catch (IllegalArgumentException ex) {
            LOG.info("rejected negative amount: {}", ex.getMessage());
        }
    }

    /**
     * Base record-like class. Real code would use a record; this stays a class to keep
     * the inheritance example explicit.
     */
    static class Money {
        private final long amountCents;
        private final String currency;

        Money(long amountCents, String currency) {
            this.amountCents = amountCents;
            this.currency = currency;
        }

        long amount() { return amountCents; }
        String currency() { return currency; }
    }

    /**
     * Subclass uses a flexible constructor body: validates inputs and normalises the
     * currency code before invoking {@code super(...)}. Pre-JDK-25 this would have
     * required either a static factory or duplicate validation in {@code Money}.
     */
    static class PositiveAmount extends Money {
        PositiveAmount(long amount, String currency) {
            // prologue — no reference to `this`, allowed before super() since JDK 25
            if (amount < 0) {
                throw new IllegalArgumentException("amount must be >= 0, got " + amount);
            }
            var normalised = currency == null ? "USD" : currency.toUpperCase();

            super(amount * 100L, normalised);

            // epilogue — `this` is available here as usual
            LOG.debug("constructed PositiveAmount {} {}", amount(), currency());
        }
    }
}
