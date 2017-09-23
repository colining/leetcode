package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/9/23.
 */
public class leetcode_416 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 11, 5};
        System.out.println(canPartition(array));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int[] helper = new int[sum/2+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = helper.length-1; j >= nums[i]; j--) {
                helper[j] = Math.max(helper[j], helper[j - nums[i]] + nums[i]);
            }
        }
        return helper[helper.length - 1] == sum / 2;
    }
}
