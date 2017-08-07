package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/7.
 */
public class leetcode_343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int num = scanner.nextInt();
            System.out.println(integerBreak(num));
        }
    }
    /*
    一个数可以分解为至少两个数的和，然后这两个数也可以再分解；
    我们不这么考虑，在我们填表的时候，只考虑当前位置所能制造的最大乘积；
    如果分解成的两个数乘积想为最大，那么必然是因为下面分解的所有小乘积是最大的
     */
    public static int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], max(dp, i-j, j));
            }
        }
        return dp[n];
    }

    private static int max(int[] dp, int i, int j) {
        i = Math.max(i, dp[i]);
        j = Math.max(j, dp[j]);
        return i * j;

    }
}
