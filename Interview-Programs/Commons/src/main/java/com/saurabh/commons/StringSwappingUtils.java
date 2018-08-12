package com.saurabh.commons;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class StringSwappingUtils {
    public static String swapOneCharacter(String string, int thisPosition, int thatPosition) {
        char temp;
        char[] charArray = string.toCharArray();

        temp = charArray[thisPosition];
        charArray[thisPosition] = charArray[thatPosition];
        charArray[thatPosition] = temp;

        return String.valueOf(charArray);
    }
}
