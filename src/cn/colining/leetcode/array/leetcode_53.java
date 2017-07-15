package cn.colining.leetcode.array;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }else
                max = Math.max(max, sum);
        }
        return max;
    }
}
