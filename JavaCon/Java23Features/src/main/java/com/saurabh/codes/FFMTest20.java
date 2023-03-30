package com.saurabh.codes;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

/**
 * “Foreign Function & Memory API”
 * The API allows access to native memory (i.e., memory outside the Java heap) and to execute native code (e.g., from C libraries) from Java.
 */
public class FFMTest20 {

    public static void main(String[] args) throws Throwable {
        // 1. Get a lookup object for commonly used libraries
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();

        // 2. Get a handle to the "strlen" function in the C standard library
        MethodHandle strlen = Linker.nativeLinker().downcallHandle(
            stdlib.find("strlen").orElseThrow(),
            FunctionDescriptor.of(JAVA_LONG, ADDRESS));

        // 3. Convert Java String to C string and store it in off-heap memory
        try (Arena offHeap = Arena.openConfined()) {
            MemorySegment str = offHeap.allocateUtf8String("Happy Coding!");

            // 4. Invoke the foreign function
            long len = (long) strlen.invoke(str);

            System.out.println("len = " + len);
        }
        // 5. Off-heap memory is deallocated at end of try-with-resources
    }
}