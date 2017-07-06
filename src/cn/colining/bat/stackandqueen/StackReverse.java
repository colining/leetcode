package cn.colining.bat.stackandqueen;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */
public class StackReverse {
    /**
     * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
     * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
     *
     * @param args
     */
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

    /*
    核心思路其实就是借助另外一个栈，递归也是一个栈；
    然后每次取得栈底的值；然后进行递归；
     */
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
