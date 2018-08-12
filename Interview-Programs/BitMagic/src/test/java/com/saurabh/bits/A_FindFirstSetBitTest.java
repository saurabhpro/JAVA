package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 19/07/17.
 */
public class A_FindFirstSetBitTest {
    @Test
    public void testSmartFirstSetBitInNumber() throws Exception {
        assertEquals(A_FindFirstSetBit.smartFirstSetBitInNumber(12), 3);
        assertEquals(A_FindFirstSetBit.smartFirstSetBitInNumber(19), 1);
        assertEquals(A_FindFirstSetBit.smartFirstSetBitInNumber(144), 5);
    }

    @Test
    public void testSimpleFirstSetBitInNumber12() throws Exception {
        assertEquals(A_FindFirstSetBit.simpleFirstSetBitInNumber(12), 3);
    }

    @Test
    public void testSimpleFirstSetBitInNumber19() throws Exception {
        assertEquals(A_FindFirstSetBit.simpleFirstSetBitInNumber(19), 1);
    }

    @Test
    public void testSimpleFirstSetBitInNumber144() throws Exception {
        assertEquals(A_FindFirstSetBit.simpleFirstSetBitInNumber(144), 5);
    }

    @Test
    public void testSimpleFirstSetBitInNumber16() throws Exception {
        assertEquals(A_FindFirstSetBit.simpleFirstSetBitInNumber(16), 5);
    }

    @Test
    public void testSimpleFirstSetBitInNumber_4() throws Exception {
        assertEquals(A_FindFirstSetBit.simpleFirstSetBitInNumber(-4), 0);
    }

}