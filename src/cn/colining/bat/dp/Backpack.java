package cn.colining.bat.dp;

/**
 * Created by colin on 2017/8/11.
 */

public class Backpack {
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};
        int n = 3;
        int cap = 6;
        System.out.println(maxValue(a, b, n, cap));
    }
    public static int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int[] dp = new int[cap+1];

        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[cap];
    }

}
