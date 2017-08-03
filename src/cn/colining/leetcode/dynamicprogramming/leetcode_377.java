package cn.colining.leetcode.dynamicprogramming;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by colin on 2017/8/2.
 */
public class leetcode_377 {
    /*
    Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

    Example:

    nums = [1, 2, 3]
    target = 4
    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)

    Note that different sequences are counted as different combinations.

    Therefore the output is 7.
     */
    public static void main(String[] args) {
        int target = 4;
        int[] array = new int[]{1, 2, 3};
        leetcode_377 leetcode_377 = new leetcode_377();
        System.out.println(leetcode_377.combinationSum4(array, target));
    }

    public int sum = 0;

    public int combinationSum4(int[] nums, int target) {
//
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        return findNum(nums, target);
        Arrays.sort(nums);
        return findNum2(nums, target);
    }
    /*
        dp方法，从前到后；
     */
    private int findNum1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < nums[j]) {
                    break;
                } else if (i == nums[j]) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    /*
    如果数组里有和target相等的数
    那么就要加一，也就是相当于将dp[0]置为1
     */
    private int findNum2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < nums[j]) {
                    break;
                } else {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
    /*
    超时的暴力递归解法
     */
    private int findNum(int[] nums, int target) {
        if (target < nums[0]) {
            if (target == 0) {
                sum++;
            }
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                combinationSum4(nums, target - nums[i]);
            }
        }
        return sum;
    }
}
