package com.saurabh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    void whenEmptyString_thanAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome(""));
        assertTrue(palindromeTester.isPalindromeLinear(""));
    }

    @Test
    void whenPalindrome_thanAccept() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("noon"));
        assertTrue(palindromeTester.isPalindromeLinear("noon"));
        assertTrue(palindromeTester.isPalindromeLinear("neoen"));
    }

    @Test
    void whenNotPalindrome_thanReject() {
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("box"));
        assertFalse(palindromeTester.isPalindromeLinear("box"));
    }

    @Test
    void whenNearPalindrome_thanReject() {
        Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("neon"));
        assertFalse(palindromeTester.isPalindromeLinear("neon"));
    }
}