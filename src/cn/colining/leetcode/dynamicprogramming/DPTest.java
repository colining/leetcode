package cn.colining.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by colin on 2017/7/29.
 */
public class DPTest {
    public static void main(String[] args) {
//        int n = 1;
//        System.out.println(func(n));
//        int[] array = new int[]{5, 1, 2, 10, 6, 2};
//        System.out.println(func2(array));

        int[] coin = new int[]{2,5,10,1};
        System.out.println(coinChange(coin, 27));
    }

    private static int func(int n) {
        int i = 0;
        int j = 1;
        if (n == 0) {
            return i;
        }
        int temp;
        int flag = 1;
        while (flag < n) {
            temp = i;
            i = j;
            j = temp + j;
            flag++;
        }
        return j;
    }

    public static int func2(int [] array) {
        int[] helper = new int[array.length+1];
        helper[1] = array[0];
        for (int i = 2; i <= array.length; i++) {
            helper[i] = Math.max(array[i - 1] + helper[i - 2], helper[i - 1]);
        }
        return helper[helper.length - 1];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] helper = new int[amount + 1];
        Arrays.fill(helper,amount+1);
        helper[0] = 0;
        for (int i = 1; i <=  amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    helper[i] = Math.min(helper[i - coins[j]]+1, helper[i]);
                }
            }

        }

        return helper[amount] > amount?-1:helper[amount];
    }
}
