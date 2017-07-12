package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/7/12.
 */
public class leetcode_121 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.

    Example 1:
    Input: [7, 1, 5, 3, 6, 4]
    Output: 5

    max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
    Example 2:
    Input: [7, 6, 4, 3, 1]
    Output: 0

    In this case, no transaction is done, i.e. max profit = 0.
     */
    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(array));
    }

    /**
     * 储存最小值,然后进行比较
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            }else {
                min = prices[i];
            }
        }
        return max;
    }

    /**
     * 通过最大字段和来求解这个问题，有点大材小用了
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] array = new int[prices.length - 1];
        for (int i = 0; i < prices.length-1; i++) {
            array[i] = prices[i + 1] - prices[i];
        }

        return findMaxIntervalSum(array);
    }

    private static int findMaxIntervalSum(int[] array) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
