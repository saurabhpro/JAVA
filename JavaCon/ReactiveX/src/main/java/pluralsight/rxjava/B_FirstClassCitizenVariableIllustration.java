/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava;

import java.util.function.BinaryOperator;

public class B_FirstClassCitizenVariableIllustration {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------
        // This example illustrates how to create an inline lambda expression
        // and store it in a variable.  It can then be called directly from
        // the variable.
        // ---------------------------------------------------------------------
        BinaryOperator<String> concatFunction = (s, t) -> s + t;
        System.out.println(concatFunction.apply("Hello ", "World 1"));

        // ---------------------------------------------------------------------
        // This example illustrates how a static method that conforms to the
        // method signature of the BiFunction can be stored in a variable and
        // then invoked.
        // ---------------------------------------------------------------------
        concatFunction = (a1, b1) -> concatStrings(a1, b1);
        System.out.println(concatFunction.apply("Hello ", "World 2"));

        // ---------------------------------------------------------------------
        // This example illustrates how an instance method that conforms to the
        // method signature of the BiFunction can be stored in a variable and
        // then invoked.
        // ---------------------------------------------------------------------
        B_FirstClassCitizenVariableIllustration instance = new B_FirstClassCitizenVariableIllustration();
        concatFunction = instance::concatStrings2;
        System.out.println(concatFunction.apply("Hello ", "World 3"));
    }

    private static String concatStrings(String a, String b) {
        return a + b;
    }

    /* package */ String concatStrings2(String a, String b) {
        return a + b;
    }
}
