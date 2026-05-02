package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JEP 506 — Scoped Values (final in JDK 25).
 *
 * <p>{@link ScopedValue} is the immutable, structured replacement for {@link ThreadLocal}.
 * Unlike a {@code ThreadLocal} that stays alive for the lifetime of the thread, a scoped
 * value is bound only inside a {@code where(...).run(...)} block — the binding disappears
 * when the block returns. Bindings are inherited by virtual threads spawned from a
 * {@code StructuredTaskScope}, which makes scoped values the recommended way to pass
 * per-request context (user, tenant, trace id) through a virtual-thread call tree
 * without leaking across requests.
 *
 * <p>References:
 * <ul>
 *   <li><a href="https://openjdk.org/jeps/506">JEP 506</a></li>
 *   <li><a href="https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/ScopedValue.html">javadoc</a></li>
 * </ul>
 */
public class ScopedValuesDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ScopedValuesDemo.class);

    private static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();
    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

    public static void main(String[] args) {
        ScopedValue.where(CURRENT_USER, "alice")
                .where(REQUEST_ID, "req-001")
                .run(ScopedValuesDemo::handleRequest);

        // Outside the where() block the values are unbound. Calling get() would throw
        // NoSuchElementException — use isBound() to check first.
        LOG.info("after scope: bound={}", CURRENT_USER.isBound());

        ScopedValue.where(CURRENT_USER, "bob").run(() ->
                LOG.info("nested call sees user={}", CURRENT_USER.get())
        );
    }

    private static void handleRequest() {
        LOG.info("user={} request={}", CURRENT_USER.get(), REQUEST_ID.get());
        loadProfile();
    }

    private static void loadProfile() {
        // No need to thread the user through method parameters — the binding is visible
        // anywhere down the call stack inside the same where() block.
        LOG.info("loading profile for {}", CURRENT_USER.get());
    }
}
