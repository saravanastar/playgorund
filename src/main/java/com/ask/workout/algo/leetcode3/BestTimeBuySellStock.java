package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeBuySellStock {

    public static void main(String[] args) {
        BestTimeBuySellStock bestTimeBuySellStock = new BestTimeBuySellStock();
        System.out.println(bestTimeBuySellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bestTimeBuySellStock.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int index = 0; index < prices.length; index++) {
            minPrice = Math.min(minPrice, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - minPrice);
        }
        return maxProfit;
    }

}
