package cn.colining.bat.dp;

/**
 * Created by colin on 2017/8/11.
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        int dp[][] = new int[n+1][m+1];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
