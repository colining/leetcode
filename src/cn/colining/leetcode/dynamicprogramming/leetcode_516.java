package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/3.
 */
public class leetcode_516 {
    /*
    最长回文子序列
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(longestPalindromeSubseq(a));
    }
    /*
    最长子序列，几乎和最长子串是一样的；
    不要先太多，只要考虑初始状态，还有状态变化就ok了
    另外我发现循环这样写，整个数组比较好看
     */
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
