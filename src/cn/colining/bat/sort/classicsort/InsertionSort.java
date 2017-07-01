package cn.colining.bat.sort.classicsort;

import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/26.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 3};
        insertionSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 每次插排一个元素，要进行n次<br>
     *     似乎我们生活中从小到大排队有点类似这样
     * @param A
     * @param n
     * @return
     */
    public static int[] insertionSort(int[] A, int n) {
        if (A == null || A.length < 2) {
            return null;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
                else
                    break;
                }

        }
        return A;
    }
}