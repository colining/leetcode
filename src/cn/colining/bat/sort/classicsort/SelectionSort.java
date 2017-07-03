package cn.colining.bat.sort.classicsort;


import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/26.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 2, 6};
        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 选择排序，每次选择最大或者最小，排序n-1次
     * @param A 待排序数组
     * @param n 数组长度
     * @return  排好序的数组
     */
    public static int[] selectionSort(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            max = 0;
            for (int j = 0; j < A.length  - i; j++) {
                if (A[j] >= max) {
                    max = A[j];
                    index = j;
                }
            }
            swap(A, index, A.length - 1 - i);

        }
        return A;
    }
}
