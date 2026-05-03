package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JEP 507 — Primitive Types in Patterns, instanceof, and switch (preview through JDK 26).
 *
 * <p>Before this JEP, pattern matching only worked on reference types. JEP 507 lifts
 * that restriction: {@code instanceof int i} and {@code case int i} are now legal,
 * and the compiler inserts the safe widening / narrowing conversion or range check.
 *
 * <p>This makes branchless conversion of an {@code Object} (e.g. JSON value) into
 * the right primitive a one-liner instead of a chain of {@code instanceof} +
 * {@code intValue()} + range guards.
 *
 * <p>Compile + run with {@code --enable-preview}.
 */
public class PrimitivePatternsDemo {

    private static final Logger LOG = LoggerFactory.getLogger(PrimitivePatternsDemo.class);

    public static void main(String[] args) {
        Object[] inputs = {42, 200_000L, 3.14, "hello"};
        for (Object input : inputs) {
            LOG.info("describe({}) = {}", input, describe(input));
        }
    }

    /**
     * Switches on an {@link Object} and uses primitive type patterns so each branch
     * receives a primitive value directly — no boxing/unboxing dance, no manual
     * range checks.
     */
    static String describe(Object value) {
        return switch (value) {
            case int i when i < 0      -> "negative int " + i;
            case int i                 -> "non-negative int " + i;
            case long l                -> "long " + l;
            case double d              -> "double " + d;
            case null                  -> "null";
            default                    -> "other (" + value.getClass().getSimpleName() + ")";
        };
    }

    /**
     * Demonstrates the same construct in {@code instanceof} form. Compared with
     * the pre-JEP-507 spelling — {@code value instanceof Integer boxed && boxed
     * .intValue() ...} — this is one statement, no boxing roundtrip.
     */
    static int unbox(Object value) {
        if (value instanceof int i) {
            return i;
        }
        throw new IllegalArgumentException("not an int: " + value);
    }
}
