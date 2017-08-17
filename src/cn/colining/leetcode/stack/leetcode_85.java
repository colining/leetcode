package cn.colining.leetcode.stack;

import java.util.Stack;

/**
 * Created by colin on 2017/8/17.
 */
public class leetcode_85 {
    public static void main(String[] args) {
        char[][] a = new char[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maximalRectangle(a));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] helper = new int[matrix[0].length];
        //这里之所以是两层循环是因为，假设我们计算从第二层开始
        //那么加上第一层也只会增大不可能减小；
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                helper[k] = matrix[i][k] == 0 ? 0 : 1 + helper[k];
            }
            max = Math.max(max, singleStack(helper));
        }
        return max;
    }


    private static int singleStack(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int cur;
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i]) {
                int k = stack.pop();
                int j = stack.isEmpty() ? -1 : stack.peek();
                cur = array[k] * (i - j - 1);
                max = Math.max(cur, max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            cur = array[j] * (array.length - k - 1);
            max = Math.max(max, cur);
        }
        return max;
    }
}
