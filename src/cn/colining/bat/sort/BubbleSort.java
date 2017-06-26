package cn.colining.bat.sort;



import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/26.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {1,9, 7, 5, 4, 6, 3, 2, 8};
        System.out.println(Arrays.toString(bubbleSort(array, array.length)));
    }

    /**
     * 冒泡排序，每次冒上一个最大值，总共需要冒上n-1个<br>
     *     因为最后一个冒不上来了:)
     * @param A 数组
     * @param n 数组长度
     * @return 拍完序的数组
     */
    public  static int[] bubbleSort(int[] A, int n) {
        for (int i =0;i<A.length-1;i++) {
            for (int j=0; j<A.length-i-1;j++) {
                if (A[j] > A[j+1]) {
                    swap(A, j,j+1);
                }
            }
        }
        return A;
    }


}
