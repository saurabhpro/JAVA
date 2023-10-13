/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class D_HighOrderFunctionIllustration {

    public static void main(String[] args) {

        Supplier<String> xformOperation = createCombineAndTransform("Hello ", "World", String::toUpperCase);

        // returned high order function is not called until we called get
        System.out.println(xformOperation.get());
    }

    /*
     * High order function - function that returns a function through interfaces and lambda
     */
    public static Supplier<String> createCombineAndTransform(
            final String a, final String b,
            final UnaryOperator<String> transformer
    ) {
        return () -> {

            String aa = a;
            String bb = b;

            if (transformer != null) {
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }

            return aa + bb;
        };
    }
}
