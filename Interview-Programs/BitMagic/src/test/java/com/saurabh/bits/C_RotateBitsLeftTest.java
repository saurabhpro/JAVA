package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 20/07/17.
 */
public class C_RotateBitsLeftTest {
    @Test
    public void testRotateLeft() throws Exception {
        assertEquals(C_RotateBitsLeft.rotateLeft(16, 3), 128);
        assertEquals(C_RotateBitsLeft.rotateLeft(-16, 3), -121);
    }


    @Test
    public void testRotateLeft2() throws Exception {
        assertEquals(Integer.rotateLeft(16, 3), 128);
        assertEquals(Integer.rotateLeft(-16, 3), -121);
    }
}