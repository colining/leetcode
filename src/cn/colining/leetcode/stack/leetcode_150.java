package cn.colining.leetcode.stack;

import java.util.Stack;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_150 {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static void main(String[] args) {
        String[] strings = new String[]{"12", "3", "/"};
        System.out.println(evalRPN(strings));
    }

    /**
     * 首先我们要明确的是：运算是从前往后的；
     * 每一个运算符都会将其前面的元素进行运算
     * 所以我们用一个栈来从前向后依次压栈
     * 每次遇到运算符，栈中必然是两个数字，否则就是错误的
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<>();
        int a = 0, b = 0;
        for (String string : tokens) {
            if (string.equals("+")) {
                integerStack.add(integerStack.pop() + integerStack.pop());
            } else if (string.equals("*")) {
                integerStack.add(integerStack.pop() * integerStack.pop());
            } else if (string.equals("/")) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.add(b / a);
            } else if (string.equals("-")) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.add(b - a);
            }else {
                integerStack.add(Integer.parseInt(string));
            }
        }
        return integerStack.pop();
    }
}
