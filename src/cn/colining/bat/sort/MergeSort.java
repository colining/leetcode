package cn.colining.bat.sort;

import java.util.Arrays;

/**
 * Created by colin on 2017/6/26.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] A = new int[]{5,6,2,4,8,51,2,6,5,6};
        int []array = mergeSort(A, A.length);
        System.out.println(Arrays.toString(array));
    }

    public static int[] mergeSort(int[] A, int n) {
        //result数组为临时数组的做法
        merge(A, new int[A.length], 0, n - 1);
        //result数组与array数组交错进行
        int []Aback = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Aback[i] = A[i];
        }
        merge1(A, Aback, 0, n - 1);
        return Aback;
    }

    /**归并排序的重点其实就是并，<br>
     * 递归很简单，左右，并就麻烦了，一直困扰我的就是为什么不直接调换<br>
     * 其实很简单 这相当于两个数组进行比较，交换了之后就破坏了比较方式<br>
     * 所以一般写法好像两个链表，合成一个链表那样<br>
     * 所以需要额外内存，一种是临时的，另一种是可以与原数组交换的方式；
     * @param array
     * @param result
     * @param left
     * @param right
     */
    private static void merge(int[] array, int result[], int left, int right) {
        if (left >= right) {
            result[left] = array[left];
            return;
        }
        int mid = (left + right) >> 1;
        merge(array, result, left, mid);
        merge(array, result, mid + 1, right);
        int leftStart = left;
        int rightStart = mid + 1;
        int k = 0;
        while (leftStart <= mid && rightStart <= right) {
            if (array[leftStart] < array[rightStart]) {
                result[k++] = array[leftStart++];
            } else {
                result[k++] = array[rightStart++];
            }
        }
        while (leftStart <= mid) {
            result[k++] = array[leftStart++];
        }
        while (rightStart <= right) {
            result[k++] = array[rightStart++];
        }
        for (int i = 0; i < k; i++) {
            array[left+i] = result[i];
        }

    }

    /**
     * 当使用result和array交错时，一定要注意指针
     * @param array
     * @param result
     * @param left
     * @param right
     */
    private static void merge1(int[] array, int result[], int left, int right) {
        if (left == right) {
            result[left] = array[left];
            return;
        }
        int mid = (left + right) >> 1;
        merge1( result,array, left, mid);
        merge1(result,array, mid + 1, right);

        int leftStart = left;
        int rightStart = mid + 1;
        int k = left;
        while (leftStart <= mid && rightStart <= right) {
            if (array[leftStart] < array[rightStart]) {
                result[k++] = array[leftStart++];
            } else {
                result[k++] = array[rightStart++];
            }
        }
        while (leftStart <= mid) {
            result[k++] = array[leftStart++];
        }
        while (rightStart <= right) {
            result[k++] = array[rightStart++];
        }


    }
}
