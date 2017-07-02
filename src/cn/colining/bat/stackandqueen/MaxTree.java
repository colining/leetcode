package cn.colining.bat.stackandqueen;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */
public class MaxTree {
    /**
     * 数组变树练习题：
     * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
     * 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
     * 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
     * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
     * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 4, 2};
        System.out.println(Arrays.toString(buildMaxTree(array, array.length)));
    }

    /**
     * 核心思路：通过进出零次栈，得到左边右边的父节点，然后比较
     * @param array
     * @param n
     * @return
     */
    public static int[] buildMaxTree(int[] array, int n) {
        int[] maxTree = new int[n];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                stack.pop();
            }
            maxTree[index++] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = array.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && (maxTree[i] == -1 || array[stack.peek()] < array[maxTree[i]])) {
                maxTree[i] = stack.peek();
            }
            stack.push(i);
        }

        return maxTree;
    }
}
