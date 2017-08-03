package cn.colining.leetcode.dynamicprogramming;

import java.util.Iterator;

/**
 * Created by colin on 2017/8/2.
 */
public class leetcode_647 {
    /*
    Given a string, your task is to count how many palindromic substrings in this string.
    The substrings with different start indexes or end indexes are counted as different
    substrings even they consist of same characters.
     */
    public static void main(String[] args) {
        String a = "";
        leetcode_647 leetcode_647 = new leetcode_647();
        System.out.println(leetcode_647.countSubstrings1(a));
    }

    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        return count;
    }

    private void palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            count++;
            left--;
            right++;
        }
    }

    public int countSubstrings1(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0 ; j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
