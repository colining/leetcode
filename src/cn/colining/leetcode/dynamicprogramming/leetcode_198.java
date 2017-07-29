package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/7/29.
 */
public class leetcode_198 {
    public static void main(String[] args) {
        int[] array = new int[]{2,5,1,7,5,9,3,2,1};
        System.out.println(rob(array));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] helper = new int[nums.length + 1];
        helper[1] = nums[0];
        for (int i = 2; i < helper.length; i++) {
            helper[i] = Math.max(nums[i-1] + helper[i - 2], helper[i - 1]);
        }
        return helper[helper.length - 1];
    }
}
