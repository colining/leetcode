package cn.colining.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by colin on 2017/8/2.
 */
public class leetcode_338 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(6 >> 1);
        while (true) {
            int num = scanner.nextInt();
            System.out.println(Arrays.toString(countBits(num)));
        }
    }

    /*
    左移之后，后面的状态就会依赖于前面的状态；
    然后考虑一下最后一位是否有值；也就是判读那奇偶
     */
    public static int[] countBits(int num) {

        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i&1);
        }
        return dp;
    }
}
