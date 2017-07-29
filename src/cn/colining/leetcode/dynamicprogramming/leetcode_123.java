package cn.colining.leetcode.dynamicprogramming;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_123 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(array));
    }

    /**
     * 自己写的基于最大字段和的解法，后面其实是暴力搜索，无法通过，
     * 向后继续思考的话，就可以改造成下面的方法
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] array = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            array[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int sum;
        if (array.length == 1) {
            return Math.max(array[0], 0);
        }
        for (int i = 1; i < array.length; i++) {
            sum = 0;
            sum += findMaxIntervalSum(array, 0, i);
            sum += findMaxIntervalSum(array, i, array.length);
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int findMaxIntervalSum(int[] array, int left, int right) {
        int sum = 0;
        int max = 0;
        for (int i = left; i < right; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    /**
     * 最简单的思路：动态规划一下，
     * 我们想知道第二次卖出后，手里有多少钱，
     * 取决于第二次买入有多少钱；
     * 而第第二次买入取决于第一次卖出是多少钱，
     * 第一次卖出取决于第一次买入；
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;
        for (int price : prices) {
            hold1 = Math.max(hold1, -price);              //第一次买入，买入价格越低越好
            release1 = Math.max(release1, hold1 + price); //第一次卖出，所持资金越高越好
            hold2 = Math.max(hold2, release1 - price);    //第二次买入，取决于当前价格和第一次卖出价格，当前价格越低越好，所持资金越高越好
            release2 = Math.max(release2, hold2 + price); //第二次售出，取决于当前价格和第二次买入是所持资金
        }
        return release2;
    }

    /**
     * 从左向右计算当前能获取的最大收益；这个就是第一次的收益
     * 然后从后向前计算当前能获得的最大收益；这个是第二次的收益
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;

        int[] leftProfit = new int[length];
        int leftMaxProfit = 0;
        int leftMin = prices[0];
        for (int i = 0; i < length; i++) {
            if (prices[i] < leftMin)
                leftMin = prices[i];
            if (prices[i] - leftMin > leftMaxProfit)
                leftMaxProfit = prices[i] - leftMin;
            leftProfit[i] = leftMaxProfit;
        }

        int maxProfit = 0;
        int rightMaxProfit = 0;
        int rightMax = prices[length - 1];
        //
        int[] right = new int[length];
        //
        for (int i = length - 1; i >= 0; i--) {
            if (prices[i] > rightMax)
                rightMax = prices[i];
            if (rightMax - prices[i] > rightMaxProfit) {
                rightMaxProfit = rightMax - prices[i];

            }
            int currentProfit = rightMaxProfit + (i > 0 ? leftProfit[i - 1] : 0);
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            right[--length] = rightMaxProfit;
        }
        return maxProfit;
    }
}
