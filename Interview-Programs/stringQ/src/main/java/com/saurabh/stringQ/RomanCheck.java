package com.saurabh.stringQ;

import java.util.regex.Pattern;

public class RomanCheck {
    public static void main(String[] args) {

    }

    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        /*
         * The problem is that it internally creates a Pattern instance for the regular expression
         * and uses it only once, after which it becomes eligible for garbage collection.
         *
         * Creating a Pattern instance is expensive because it requires
         * compiling the regular expression into a finite state machine.
         */
    }


}


// Reusing expensive object for improved performance
class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
