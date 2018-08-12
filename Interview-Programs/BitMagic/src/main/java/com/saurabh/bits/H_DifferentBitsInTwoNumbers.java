package com.saurabh.bits;

/**
 * 1. Calculate XOR of A and B.
 * a_xor_b = A ^ B
 * 2. Count the set bits in the above
 * calculated XOR result.
 * countSetBits(a_xor_b)
 * Created by saurabhkumar on 31/07/17.
 */
public class H_DifferentBitsInTwoNumbers {
    // Function that count set bits
    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // Function that return count of
// flipped number
    static int FlippedCount(int a, int b) {
        // Return count of set bits in
        // a XOR b
        return countSetBits(a ^ b);
    }
}
