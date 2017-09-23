package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/19.
 */
public class leetcode_486 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            PredictTheWinner(array);
        }
    }

    public static boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int first = getFirstNumber(nums,0,nums.length-1);
        return first > sum - first;
    }

    private static int getFirstNumber(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(nums[i] + getSecond(nums, i + 1, j), nums[j] + getSecond(nums, i, j - 1));
    }

    private static int getSecond(int[] nums, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(getFirstNumber(nums, i + 1, j), getFirstNumber(nums, i, j - 1));
    }
}
