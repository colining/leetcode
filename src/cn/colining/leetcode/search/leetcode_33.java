package cn.colining.leetcode.search;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by colin on 2017/7/16.
 */
public class leetcode_33 {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
     */
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(array, 6));
    }

    /*
    加了一些判断的二分搜索
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //如果nums[mid]>=nums[start] 说明前面肯定是有序的
            //可以判断一下目标是否在这有序的部分
            if (nums[mid] >= nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            //如果nums[mid] <= nums[end]，说明后面是有序的，
            //可以判断一下目标是不是在这部分
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    /*
    普通二分搜索的做法
     */
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                left--;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return left;
    }

}
