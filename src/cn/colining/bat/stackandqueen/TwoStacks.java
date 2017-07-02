package cn.colining.bat.stackandqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */
public class TwoStacks {
    /**
     * 将栈排序为升序，尽可以使用一个辅助栈
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3};
        System.out.println(Arrays.asList(twoStacksSort(array)));
    }
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //将数组修改为栈
        for (int i = numbers.length-1; i >=0;i--) {
            stack.push(numbers[i]);
        }
        sortStack(stack, helpStack);


        for (Integer integer : stack) {
            arrayList.add(integer);
        }
        return  arrayList;
    }

    private static void sortStack(Stack<Integer> stack, Stack<Integer> helpStack) {
        while (!stack.empty()) {
            if (helpStack.empty() || stack.peek() < helpStack.peek()) {
                helpStack.push(stack.pop());
            }
            else {
                int temp = stack.pop();
                while (!helpStack.empty() && helpStack.peek() < temp) {
                    stack.push(helpStack.pop());
                }
                helpStack.push(temp);
            }
        }
        for (Integer integer : helpStack) {
            stack.push(integer);
        }
    }

}
