package com.saurabh.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link ScopedValue} (JEP 506, final in JDK 25), with side-by-side cases
 * against {@link ThreadLocal} so the behavioural differences are explicit.
 */
class ScopedValuesDemoTest {

    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    @Test
    void value_is_bound_inside_where_block() {
        // when
        var seen = new AtomicReference<String>();
        ScopedValue.where(USER, "alice").run(() -> seen.set(USER.get()));

        // then
        assertThat(seen.get()).isEqualTo("alice");
    }

    @Test
    void value_is_unbound_after_where_block_returns() {
        // given
        ScopedValue.where(USER, "alice").run(() -> {/* no-op */});

        // when / then
        assertThat(USER.isBound()).isFalse();
        assertThatThrownBy(USER::get).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void inner_where_block_shadows_outer_binding() {
        // given
        var inner = new AtomicReference<String>();
        var afterInner = new AtomicReference<String>();

        // when
        ScopedValue.where(USER, "alice").run(() -> {
            ScopedValue.where(USER, "bob").run(() -> inner.set(USER.get()));
            afterInner.set(USER.get());
        });

        // then — outer binding restored once the inner block returns
        assertThat(inner.get()).isEqualTo("bob");
        assertThat(afterInner.get()).isEqualTo("alice");
    }

    @Test
    void plain_virtual_thread_does_not_inherit_binding() {
        // given
        var thrown = new AtomicReference<Throwable>();

        // when — a virtual thread started ad-hoc with Thread.ofVirtual().start() is
        // *not* a child of the scope, so the binding does not propagate. Only
        // StructuredTaskScope (still preview as of JDK 25) inherits scoped values.
        ScopedValue.where(USER, "alice").run(() -> {
            try {
                Thread.ofVirtual().start(() -> {
                    try {
                        USER.get();
                    } catch (Throwable t) {
                        thrown.set(t);
                    }
                }).join();
            } catch (InterruptedException _) {
                Thread.currentThread().interrupt();
            }
        });

        // then — child thread sees an unbound ScopedValue
        assertThat(thrown.get()).isInstanceOf(NoSuchElementException.class);
    }

    /**
     * The key contrast with {@link ThreadLocal}: a scoped value cannot be reassigned
     * inside its block. There is no {@code set(...)}, only {@code where(...).run(...)}
     * which produces a fresh binding for the nested block. Compared with the
     * {@link ThreadLocalContrast} cases below, this rules out one entire class of
     * bugs (mid-call mutation of ambient context).
     */
    @Nested
    class ThreadLocalContrast {

        @Test
        void thread_local_keeps_value_after_call_until_removed() {
            // given
            ThreadLocal<String> tl = new ThreadLocal<>();
            tl.set("alice");
            try {
                // when — value persists across method boundaries on the same thread
                runOnSameThread(() -> assertThat(tl.get()).isEqualTo("alice"));

                // then — and stays bound until explicitly cleared
                assertThat(tl.get()).isEqualTo("alice");
            } finally {
                tl.remove();
            }
        }

        @Test
        void thread_local_can_be_overwritten_mid_call_unlike_scoped_value() {
            // given
            ThreadLocal<String> tl = new ThreadLocal<>();
            tl.set("alice");

            // when — any code on the thread can mutate the binding without our consent
            try {
                runOnSameThread(() -> tl.set("hijacked"));

                // then
                assertThat(tl.get()).isEqualTo("hijacked");
            } finally {
                tl.remove();
            }
        }

        @Test
        void thread_local_does_not_propagate_to_virtual_thread_unless_inheritable() {
            // given
            ThreadLocal<String> tl = new ThreadLocal<>();
            tl.set("alice");
            var seen = new AtomicReference<String>();

            // when — plain ThreadLocal is not inherited; child thread sees null
            try {
                Thread.ofVirtual().start(() -> seen.set(tl.get())).join();
            } catch (InterruptedException _) {
                Thread.currentThread().interrupt();
            } finally {
                tl.remove();
            }

            // then
            assertThat(seen.get()).isNull();
        }

        private void runOnSameThread(Runnable r) {
            r.run();
        }
    }
}
