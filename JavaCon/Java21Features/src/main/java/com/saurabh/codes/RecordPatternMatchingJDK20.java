package com.saurabh.codes;

public class RecordPatternMatchingJDK20 {

    /**
     * If a record class is generic then it can be used in a record pattern as either a parameterized type or as a raw type. For example:
     */
    record Box<T>(T t) {

    }

    static void test1(Box<String> bo) {
        if (bo instanceof Box<String>(var s)) {
            System.out.println("String " + s);
        }
    }

    /**
     * Here the record class type in the record pattern is a parameterized type.
     * It could be written equivalently as follows, in which case the type argument is inferred:
     */
    static void test2(Box<String> bo) {
        if (bo instanceof Box(var s)) {    // Inferred to be Box<String>(var s)
            System.out.println("String " + s);
        }
    }

    static class EnhancedSwitch {

        class A {

        }

        class B extends A {

        }

        sealed interface I permits C, D {

        }

        final class C implements I {

        }

        final class D implements I {

        }

        record Pair<T>(T x, T y) {

        }

        Pair<A> p1;
        Pair<I> p2;

        // the switch has to be exhaustive
        public String test() {
            return switch (p1) {
                case Pair<A>(A a, B b) -> "";
                case Pair<A>(B b, A a) -> "";
                case Pair<A>(A a1, A a2) -> "";
            };
        }
    }
}
