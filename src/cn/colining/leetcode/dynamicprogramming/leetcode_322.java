package cn.colining.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by colin on 2017/7/29.
 */
public class leetcode_322 {
    /*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:
    coins = [1, 2, 5], amount = 11
    return 3 (11 = 5 + 5 + 1)

    Example 2:
    coins = [2], amount = 3
    return -1.

    Note:
    You may assume that you have an infinite number of each kind of coin.
     */
    public static void main(String[] args) {

    }

    /*
    dp:手中持有金钱与之前找零多少和持有多少是有关系的
    设f(n) 为持有金额为n时的最少找钱数，那么他就依赖于
    前一次找钱的金额d[j]，f(n) = f(n-d[j])+1
    然后d[j] 就是我们的货币池，我们可以挨个试，直到找到最小的；
    由于f(0)=0；所以我们可以从前向后计算，也就是填表；
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] helper = new int[amount + 1];
        Arrays.fill(helper, amount + 1);
        helper[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    helper[i] = Math.min(helper[i - coins[j]] + 1, helper[i]);
                }
            }

        }
        return helper[amount] > amount ? -1 : helper[amount];
    }
}
