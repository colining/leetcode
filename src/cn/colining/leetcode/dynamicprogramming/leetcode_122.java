package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/7/12.
 */
public class leetcode_122 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        int a = 5;
        System.out.println(-a);
        System.out.println(maxProfit(array));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        int temp;
        for (int i = 0; i < prices.length-1; i++) {
            temp = prices[i + 1] - prices[i];
            if (temp > 0) {
                sum += temp;
            }
        }
        return sum;
    }

}
