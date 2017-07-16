package cn.colining.leetcode.search;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by colin on 2017/7/16.
 */
public class leetcode_33 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(array, 6));
    }

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

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
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

}
