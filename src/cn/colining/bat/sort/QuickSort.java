package cn.colining.bat.sort;


import java.util.Arrays;

/**
 * Created by colin on 2017/6/26.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,2,4,6,3,21,5,8};
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
    public static int[] quickSort(int[] A, int n) {
        quick(A, 0, n - 1);
        return A;
    }

    /**
     * 递归调换顺序，每次将一个哨兵移到正确的位置<br>
     *     递归结束条件为左右位置一样，即只有一个值
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int[] quick(int[] a, int left, int right) {
        if (left < right) {
            int sentry = sort(a,left,right);
            quick(a, left, sentry-1);
            quick(a, sentry+1, right);
        }
        return a;
    }

    /**
     * 调换位置的函数，以哨兵为界，一边大，一边小
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
}