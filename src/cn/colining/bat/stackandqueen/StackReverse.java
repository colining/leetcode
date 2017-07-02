package cn.colining.bat.stackandqueen;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */
public class StackReverse {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(reverseStack(array, array.length)));
    }
    public static int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            stack.push(A[i]);
        }
        reverseStack(stack);

        for (int i = A.length - 1; i >= 0; i--) {
            A[i] = stack.pop();
        }
        return A;
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = get(stack);
        reverseStack(stack);
        stack.push(i);
    }

    private static int get(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }
}
