package cn.colining.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_88 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] array1 = new int[]{2, 4, 6, 8};
        merge(array, 5, array1, 4);
        System.out.println(Arrays.toString(array));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length < m + n||nums2 == null) {
            return;
        }
        int i = nums1.length-1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[i] = nums2[n--];
            } else {
                nums1[i] = nums1[m--];
            }
            i--;
        }
        while (n >= 0) {
            nums1[i--] = nums2[n--];

        }
    }

}
