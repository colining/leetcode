package cn.colining.bat.binarysearch;

/**
 * Created by colin on 2017/7/7.
 */
public class Find {
    /**
     * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
     * 如果所有位置上的数都不满足条件，返回-1。
     * 给定有序数组arr及它的大小n，请返回所求值。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 2, 3};
        System.out.println(findPos(array, array.length));
    }

    /**
     * 重要条件：数组有序，不含重复元素；<br>
     * 数组有序，自然可以进行二分<br>
     * 不含重复元素，可以认为递增的步长一定大于一：<br>
     * 如果arr[mid]< mid 那么arr数组在mid前的元素也必然<br>
     *
     * @param arr 待排序数组
     * @param n   数组长度
     * @return
     */
    public static int findPos(int[] arr, int n) {
        int result = -1;
        if (arr[0] > n - 1 || arr[n - 1] < 0) {
            return result;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < mid) {
                left = mid + 1;
            } else if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
