package cn.colining.bat.stackandqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by colin on 2017/7/2.
 */

public class TwoStack {
    /**
     * 通过双栈实现队列
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 0, 4, 0, 5};
        System.out.println(Arrays.toString(twoStack1(array, array.length)));
    }

    /**
     * 比较符合实际的做法，但由于是队列，其实并不需要这么做；
     * @param ope
     * @param n
     * @return
     */
    public static int[] twoStack(int[] ope, int n) {
        ArrayList<Integer> arrayList = new ArrayList();
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i] > 0) {
                pushStack.push(ope[i]);
            } else {
                getPop(arrayList, pushStack, popStack);
            }
        }
        int[] array = new int[arrayList.size()];
        int index = 0;
        for (Integer integer : arrayList) {
            array[index++] = integer;
        }
        return array;
    }

    private static void getPop(ArrayList<Integer> arrayList, Stack<Integer> pushStack, Stack<Integer> popStack) {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        arrayList.add(popStack.pop());
    }

    public static int[] twoStack1(int[] ope, int n) {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        int count=0;
        for (int i = 0; i < ope.length; i++) {

            if (ope[i] > 0) {
                pushStack.push(ope[i]);
            }else
                count++;
        }
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            result[index++] = popStack.pop();

        }
        return result;
    }

}