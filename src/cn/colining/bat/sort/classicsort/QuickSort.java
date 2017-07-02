package cn.colining.bat.sort.classicsort;


import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/26.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 4, 6, 8,4};
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static int[] quickSort(int[] A, int n) {
        quick(A, 0, n - 1);
        return A;
    }

    /**
     * 递归调换顺序，每次将一个哨兵移到正确的位置<br>
     * 递归结束条件为左右位置一样，即只有一个值
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int[] quick(int[] a, int left, int right) {
        if (left < right) {
            int sentry = sort3(a, left, right);
            quick(a, left, sentry - 1);
            quick(a, sentry + 1, right);
        }
        return a;
    }

    /**
     * 调换位置的函数，以哨兵为界，一边大，一边小
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int sort(int[] array, int left, int right) {
        int sentry = array[left];
        while (left < right) {
            while (array[right] > sentry && right > left)
                right--;
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            while (array[left] < sentry && left < right)
                left++;
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = sentry;
        return left;
    }

    /**
     * 分区的思路，只要将小的扔一边，大的扔一边就ok了；
     * 也可以不扔大的，只将小数往前移，这样最后也就有序了
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int sort1(int[] array, int left, int right) {
        //前后都移动
        int sentry = array[left];
        int indexOfMin = left - 1;
        int indexOfMax = right + 1;
        int index = left;
        while (index < indexOfMax) {
            if (array[index] < sentry) {
                swap(array, ++indexOfMin, index++);
            } else if (array[index] > sentry) {
                swap(array, --indexOfMax, index);
            } else
                index++;
        }
        return indexOfMin + 1;

    }

    private static int sort3(int[] array, int left, int right) {
        int pivot = left - 1;
        int index = left;
        //这里注意index可以==right，这样的话扫描到最后
        //就可以将sentry也放到值小的区域；这样哨兵就到了正确位置，
        //左边比它小，右边比它大
        while (index <= right) {
            if (array[index] <= array[right]) {
                swap(array, ++pivot, index);
            }
            index++;
        }
        return pivot;
    }
}