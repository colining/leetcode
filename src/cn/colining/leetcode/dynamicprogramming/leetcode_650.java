package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/2.
 */
public class leetcode_650 {
    /*
    Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.
    Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
    Output the minimum number of steps to get n 'A'.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num = scanner.nextInt();
            System.out.println(minSteps1(num));
        }
    }
    /*
    思路其实就是从前往后推的，如果是质数，就只能一个一个加起来，无法分解
    如果不是质数，就需要分解
     */
    public static int minSteps(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 2;
        boolean flag;
        int max;
        for (int i = 3; i <= n ; i++) {
            flag = false;
            max = 0;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    flag = true;
                    max = Math.max(j, max);
                }
            }
            if (flag) {
                dp[i] = dp[max] + (i / max);
            }else {
                dp[i] = i;
            }
        }
        return dp[n];
    }

    public static int minSteps1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <=n ; i++) {
            dp[i] = i;
            for (int j = i-1; j >1 ; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
