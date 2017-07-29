package cn.colining.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by colin on 2017/7/29.
 */
public class leetcode_646 {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 100000000}, {3, 500}, {501, 505}, {3, 501}, {1001, 10002}, {4, 5}, {100000, 1000000}};
        System.out.println(findLongestChain2(array));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    public static int findLongestChain2(int[][] pairs) {
        //按照第二个数来排序，使得整体是一个可能成为最大链表的序列
        //没有之一，所以从前向后一次遍历就够了
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            //我们可以认为如果没连上，那么对整体来说前面的那个pair，
            //一定可以代替当前pair；也就是sum一定是相等的，不会变化；
            //所以只有到可以连上时，才会对整体产生变化
            while (i + 1 < n && pairs[i + 1][0] <= curEnd)
                i++;
        }
        return sum;
    }


}
