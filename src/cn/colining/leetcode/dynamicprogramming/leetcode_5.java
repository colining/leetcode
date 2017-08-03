package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/8/2.
 */
public class leetcode_5 {
    public static void main(String[] args) {
        String a = "babad";
        System.out.println(longestPalindrome(a));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0 ; j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i - 1][j + 1]);
                if (dp[i][j]&& (i-j+1>res.length())) {
                    res = s.substring(j, i+1);
                }
            }
        }
        return res;
    }
}
