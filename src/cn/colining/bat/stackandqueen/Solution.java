package cn.colining.bat.stackandqueen;

import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */
public class Solution {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * 其实就是双栈结构，看过好多遍了；
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if (minStack.empty() || minStack.peek() >= node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
