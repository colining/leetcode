package cn.colining.bat.stackandqueen;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by colin on 2017/7/2.
 */
public class SlideWindow {
    /**
     * 滑动窗口练习
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(slide(array, array.length, 3)));
    }

    /**
     * 核心思路，就是通过双向队列记录可能的最大值，再输出即可
     * @param arr   数组
     * @param n     数组大小
     * @param w     窗口大小
     * @return      滑动窗口最大值
     */
    public static int[] slide(int[] arr, int n, int w) {
        int[] slide = new int[n - w + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peek() + w == i) {
                deque.pollFirst();
            }
            if (i >= w - 1) {
                slide[index++] = arr[deque.peek()];
            }
        }
        return slide;
    }
}
