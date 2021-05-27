package com.saurabh;

public class Palindrome {

    public boolean isPalindrome(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }

    public boolean isPalindromeLinear(String inputString) {
        int start = 0;
        int end = inputString.length() - 1;
        boolean rv = true;
        while (end > start) {
            char firstChar = inputString.charAt(start);
            char lastChar = inputString.charAt(end);
            if (firstChar != lastChar) {
                rv = false;
                break;
            }
            start++;
            end--;
        }
        return rv;
    }
}