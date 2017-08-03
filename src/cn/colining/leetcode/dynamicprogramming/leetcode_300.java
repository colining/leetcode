package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/8/3.
 */
public class leetcode_300 {
    public static void main(String[] args) {
        int[] array = new int[]{0};
        System.out.println(lengthOfLIS(array));
    }


    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
