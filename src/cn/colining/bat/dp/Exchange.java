package cn.colining.bat.dp;

import java.util.HashMap;

/**
 * Created by colin on 2017/7/30.
 */
public class Exchange {
    public static void main(String[] args) {
        int[] penny = new int[]{1,4,5,8,10};
        int n = penny.length;
        int aim = 5;
        Exchange e = new Exchange();
        System.out.println(e.countWays(penny, n, aim));
    }

    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || n == 0 || aim == 0) {
            return 0;
        }
//        return process(penny,0, aim);
//        int[][] map = new int[n + 1][aim + 1];
//        return process2(penny, 0, aim,map);
        return process3(penny, penny.length, aim);
    }


    private int process(int[] penny, int index, int aim) {
        int res = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }

        for (int i = 0; i * penny[index] <= aim; i++) {
            res += process(penny, index + 1, aim - i * penny[index]);
        }
        return res;
    }

    private int process2(int[] penny, int index, int aim, int[][] map) {
        int res = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }
        int mapValue = 0;
        for (int i = 0; i * penny[index] <= aim; i++) {
            mapValue = map[index + 1][aim - i * penny[index]];
            if (mapValue != 0) {
                res += mapValue == -1 ? 0 : mapValue;
            } else {
                res += process2(penny, index + 1, aim - i * penny[index], map);
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    private int process3(int[] penny, int n, int aim) {
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < aim+1; j++) {
            if (j % penny[0] == 0) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim+1; j++) {
                int temp = j >= penny[i] ? dp[i][j - penny[i]] : 0;
                dp[i][j] = dp[i - 1][j] + temp;
            }
        }
        return dp[penny.length - 1][aim];
    }
}
