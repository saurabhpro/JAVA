package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class I_MaxConsecutiveOnesTest {
    @Test
    public void testNumberOfConsecutiveOnesFromRightNegativeOne() throws Exception {
        assertEquals(I_MaxConsecutiveOnes.numberOfConsecutiveOnesFromRight(-1), 32);
    }

    @Test
    public void testNumberOfConsecutiveOnesFromRightZero() throws Exception {
        assertEquals(I_MaxConsecutiveOnes.numberOfConsecutiveOnesFromRight(0), 0);
    }

    @Test
    public void testNumberOfConsecutiveOnesFromRightPositive() throws Exception {
        assertEquals(I_MaxConsecutiveOnes.numberOfConsecutiveOnesFromRight(23), 3);
    }
}