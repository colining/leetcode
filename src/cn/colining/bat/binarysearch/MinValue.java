package cn.colining.bat.binarysearch;

import java.util.Arrays;

/**
 * Created by colin on 2017/7/7.
 */
public class MinValue {
    /**
     * 对于一个有序循环数组arr，返回arr中的最小值。
     * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
     * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
     * 给定数组arr及它的大小n，请返回最小值。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{230,365,486,508,101};
        System.out.println(getMin(array, array.length));
    }

    /**
     * 有序：最小值一定在第一位<br>
     * 有序循环：最小值前面一定是一个大值；<br>
     * arr[left] >arr[mid] 最小值位于left~mid<br>
     * arr[right] < arr[mid] 最小值位于right~mid<br>
     * @param arr
     * @param n
     * @return
     */
    public static int getMin(int[] arr, int n) {
        int result = 0;
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] < arr[right]) {
            return arr[left];
        } else {
            int mid = left + ((right - left) >> 1);
            if (arr[left] > arr[mid]) {
                right = mid;
                result = findMin(arr, left, right);
            } else if (arr[right] < arr[mid]) {
                left = mid;
                result = findMin(arr, left, right);
            } else {
                Arrays.sort(arr);
                result = arr[0];
            }
        }
        return result;
    }


    private static int findMin(int[] arr, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            if (arr[mid] < arr[right]) {
                right = right - 1;
            }
            if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
        }
        return 0;
    }
}
