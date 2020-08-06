package com.saurabh.junit4legacy.stringconcat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class TestAssertions {

    @Test
    public void testAssertions() {
        //test data
        String str1 = new String("abc");
        String str2 = new String("abc");

        String str4 = "abc";
        String str5 = "abc";

//Check that two objects are equal
        assertEquals(str1, str2);
        //Check if two object references point to the same object
        assertSame(str4, str5);

    }
}
