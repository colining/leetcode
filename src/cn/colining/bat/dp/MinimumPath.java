package cn.colining.bat.dp;

/**
 * Created by colin on 2017/7/30.
 */
public class MinimumPath {
    public static void main(String[] args) {
        int[][] map = new int[][]{{1, 2, 3}, {1, 1, 1}};
        System.out.println(getMin(map, map.length, map[0].length));
    }
    public static int getMin(int[][] map, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] += dp[0][i - 1] + map[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0] + map[i][0];
        }

        return fun1(map,dp, n, m);
    }

    private static int fun1(int[][] map, int[][] dp, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}