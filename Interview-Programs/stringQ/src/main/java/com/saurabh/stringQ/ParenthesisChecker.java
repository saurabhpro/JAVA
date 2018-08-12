package com.saurabh.stringQ;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 * <p>
 * <p>
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * Each test case consist of a string of expression, in a separate line.
 * <p>
 * Output:
 * <p>
 * Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 100
 * 1 ≤ |s| ≤ 100
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * 3
 * {([])}
 * ()
 * ()[]
 * <p>
 * Output:
 * balanced
 * balanced
 * balanced
 * Created by saurabhkumar on 23/07/17.
 */
class ParenthesisChecker {
    /**
     * @param parenthesisString
     * @return
     */
    static boolean isParenthesisBalanced(String parenthesisString) {
        Deque<Character> pList = new ArrayDeque<Character>();
        boolean check = false;

        for (int i = 0; i < parenthesisString.length(); i++) {
            if (parenthesisString.charAt(i) == '{' || parenthesisString.charAt(i) == '[' || parenthesisString.charAt(i) == '(') {
                pList.push(parenthesisString.charAt(i));
            } else if (parenthesisString.charAt(i) == '}' || parenthesisString.charAt(i) == ']' || parenthesisString.charAt(i) == ')') {
                Character c = pList.pop();
                check = findMatch(c, parenthesisString.charAt(i));
                if (!check)
                    break;
            } else
                throw new IllegalArgumentException("Unknown symbol read : " + parenthesisString.charAt(i));
        }
        return check;
    }

    static boolean findMatch(Character c, char c1) {
        return (c == '{' && c1 == '}') || (c == '[' && c1 == ']') || (c == '(' && c1 == ')');
    }
}
