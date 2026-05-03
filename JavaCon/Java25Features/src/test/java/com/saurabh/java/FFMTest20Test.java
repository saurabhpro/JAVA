package com.saurabh.java;

import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the Foreign Function & Memory API (JEP 454, final in JDK 22).
 *
 * <p>The demo links to {@code strlen} from the C standard library — we do the same
 * here, then actually invoke it on an off-heap UTF-8 string and assert the
 * length matches {@code String#length} for an ASCII input.
 */
class FFMTest20Test {

    @Test
    void strlen_handle_can_be_resolved_from_default_lookup() {
        // given
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();

        // when
        var strlen = stdlib.find("strlen");

        // then — symbol is present on every supported platform's libc
        assertThat(strlen).isPresent();
    }

    @Test
    void strlen_returns_byte_length_of_offheap_utf8_string() throws Throwable {
        // given
        Linker linker = Linker.nativeLinker();
        MethodHandle strlen = linker.downcallHandle(
                linker.defaultLookup().find("strlen").orElseThrow(),
                FunctionDescriptor.of(JAVA_LONG, ADDRESS)
        );

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment cString = arena.allocateFrom("Happy Coding!");

            // when
            long len = (long) strlen.invoke(cString);

            // then — for pure ASCII, byte length == char length
            assertThat(len).isEqualTo("Happy Coding!".length());
        }
    }
}
