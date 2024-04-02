package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class CoinChangeProblemII {
    Integer[][] lookup;
    public static void main(String[] args) {
        CoinChangeProblemII coinChangeProblemII = new CoinChangeProblemII();
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(coinChangeProblemII.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        lookup = new Integer[coins.length+1][amount+1];
        int total =  coinChange(amount, coins, 0, 0);
        return total;
    }

    public int coinChange(int amount, int[] coins, int currentSum, int index) {

        if (currentSum > amount || index == coins.length) {
            return 0;
        }
        if (currentSum == amount) {
            return 1;
        }
        if (index < coins.length && lookup[index][currentSum] != null) {
            return lookup[index][currentSum];
        }

        int total = coinChange(amount, coins, currentSum + coins[index], index)

                + coinChange(amount, coins, currentSum, index + 1);
        lookup[index][currentSum] = total;
        return total;
    }
}
