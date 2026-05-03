package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

/**
 * JEP 505 — Structured Concurrency (preview through JDK 26).
 *
 * <p>{@link StructuredTaskScope} ties the lifetime of concurrent subtasks to a single
 * lexical scope: forks are joined or cancelled together when the scope closes, so
 * leaks and orphaned tasks become impossible to construct accidentally.
 *
 * <p>Typical use is fan-out then aggregate: fork two or more independent calls in a
 * scope, {@code join()}, then combine results. The scope also owns cancellation —
 * if one subtask fails the others can be cancelled in lockstep depending on the
 * joiner used.
 *
 * <p>Compile + run with {@code --enable-preview}.
 */
public class StructuredConcurrencyDemo {

    private static final Logger LOG = LoggerFactory.getLogger(StructuredConcurrencyDemo.class);

    public static void main(String[] args) throws Exception {
        var combined = fetchInParallel("alice");
        LOG.info("combined = {}", combined);
    }

    static String fetchInParallel(String userId) throws InterruptedException {
        try (var scope = StructuredTaskScope.open()) {
            Subtask<String> profile = scope.fork(() -> slow("profile:" + userId, Duration.ofMillis(50)));
            Subtask<String> orders = scope.fork(() -> slow("orders:" + userId, Duration.ofMillis(50)));

            scope.join();

            return profile.get() + " | " + orders.get();
        }
    }

    private static String slow(String value, Duration delay) throws InterruptedException {
        Thread.sleep(delay);
        return value;
    }
}
