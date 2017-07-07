package cn.colining.bat.binarysearch;

/**
 * Created by colin on 2017/7/7.
 */
public class LeftMostAppearance {
    /**
     * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
     * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4};
        System.out.println(findPos(array, array.length, 3));
    }

    /**
     * 这个没啥好说的，典型二分搜索嘛
     * @param arr
     * @param n
     * @param num
     * @return
     */
    public static int findPos(int[] arr, int n, int num) {
        int left = 0;
        int right = n - 1;
        int mid = 0;
        int result = -1;
        while (left < right) {
            mid = (right - left) >> 1 + left;
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            }else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
