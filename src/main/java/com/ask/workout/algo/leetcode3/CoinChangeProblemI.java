package com.ask.workout.algo.leetcode3;


/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChangeProblemI {

    public static void main(String[] args) {
        CoinChangeProblemI coinChangeProblemI = new CoinChangeProblemI();
        int[] coins = {1,2,5};
        int amount =  11;
        System.out.println(coinChangeProblemI.coinChange(coins, amount));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin: coins
                 ) {
                if (i >= coin && dp[i -coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+ dp[i - coin]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
