package com.ask.workout.algo.leetcode2;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class TradeBestTime {

    public static void main(String[] args) {
        TradeBestTime tradeBestTime = new TradeBestTime();
        System.out.println(tradeBestTime.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
            int low = Integer.MAX_VALUE;
            int maxProfit = 0;
        for (int index = 0; index < prices.length; index++) {
                if (prices[index] < low) {
                    low = prices[index];
                    continue;
                }
                int profit = prices[index] - low;
                maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
