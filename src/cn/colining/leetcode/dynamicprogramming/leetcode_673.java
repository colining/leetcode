package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/18.
 */
public class leetcode_673 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(findNumberOfLIS(array));
            System.out.println(findNumberOfLIS1(array));
        }
    }

    private static int findNumberOfLIS1(int[] nums) {
        int n = nums.length;
        int result = 0;
        int maxLen = 0;
        int[] len = new int[n], cnt = new int[n];
        //以每个位置为截止，得到每个位置的最大递增序列的长度；
        //并且我们需要保存这个长度下的最大递增序列的个数；
        for (int i = 0; i < n; i++) {
            //如果当前位置是最小值，就是一。所以初始化就是一；
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                //当前位置和前面某个位置可以递增；
                if (nums[i] > nums[j]) {
                    //如果长度恰好相差一个，那么i的位置的最大递增序列的数量可以
                    //加上以j为截止的最大递增序列的数量；
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    //如果小的话，说明最大递增序列是被刷新的；
                    //这个时候最大递增序列的数量就是以j为截止的最大递增序列的数量；
                    if (len[i] < len[j]+1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (maxLen == len[i])
                result += cnt[i];
            if (maxLen < len[i]) {
                maxLen = len[i];
                result = cnt[i];
            }
        }
        return result;
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] helper = new int[nums.length];
        helper[0] = 1;
        int max = -1;
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    helper[i] = Math.max(helper[i], helper[j] + 1);
                } else {
                    helper[i] = Math.max(helper[i], helper[j]);
                }
            }
        }
        if (helper[0] == helper[helper.length - 1]) {
            return helper.length;
        }
        for (int i : helper) {
            System.out.println(i);
        }
        for (int i = 0; i < helper.length - 1; i++) {
            if (helper[i] >= helper[helper.length - 1] - 1) {
                number++;
            }
        }
        return number;
    }
}
