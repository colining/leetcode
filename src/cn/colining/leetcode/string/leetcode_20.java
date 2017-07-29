package cn.colining.leetcode.string;

import java.util.Stack;

/**
 * Created by colin on 2017/7/22.
 */
public class leetcode_20 {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public static void main(String[] args) {
        System.out.println(isValid("(){}[(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isPair(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPair(Character pop, char c) {
        if (pop == '}' || pop == ']' || pop == ')') {
            return false;
        } else if (pop == '{' && c == '}') {
            return true;
        } else if (pop == '(' && c == ')') {
            return true;
        } else if (pop == '[' && c == ']') {
            return true;
        }
        return false;
    }
}
