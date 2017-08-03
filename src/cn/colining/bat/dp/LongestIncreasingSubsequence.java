package cn.colining.bat.dp;

import java.util.Arrays;

/**
 * Created by colin on 2017/7/30.
 */

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,7,9};
        System.out.println(Arrays.binarySearch(array, 0, 3, 5));
    }
    public int getLIS(int[] A, int n) {
        if (A == null || A.length == 0) {
            return 0;
        }
        return fun2(A, n);
        // write code here
    }

    /*
    核心思想 dp数组代表了以某个数字结尾的最长递增子序列的大小
    比如dp[i] 就是以i位置结尾，前面最长的；
    已知的条件呢：dp[0] = 1
    当我们要求dp[i]的时候，就在前面看看有没有比他小的；
    然后找到比他小，且值最大的；
     */
    private int fun1(int[] a, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    max = Math.max(max, dp[i]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private int fun2(int[] nums, int n) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}