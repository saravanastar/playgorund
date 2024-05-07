package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs costClimbingStairs = new MinCostClimbingStairs();
        System.out.println(costClimbingStairs.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(costClimbingStairs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    int[] lookup;
    public int minCostClimbingStairs(int[] cost) {
        lookup = new int[cost.length];
        lookup[0] = cost[0];
        lookup[1] = cost[1];
        return Math.min(minCostClimbingStairs(cost, cost.length-1), minCostClimbingStairs(cost, cost.length-2));
    }

    public int minCostClimbingStairs(int[] cost, int currentIndex) {

       if (currentIndex < 0) {
           return 0;
       }
       if (lookup[currentIndex] != 0) {
           return lookup[currentIndex];
       }

       lookup[currentIndex] =  cost[currentIndex] + Math.min(minCostClimbingStairs(cost, currentIndex-1), minCostClimbingStairs(cost, currentIndex-2));

       return lookup[currentIndex];

    }

    public int minCostClimbingStairsOptimized(int[] cost) {

      int[] dp = new int[cost.length];

        for (int index = 0; index < cost.length; index++) {
            if (index < 2) {
                dp[index] = cost[index];

            } else {
                dp[index] = cost[index] + Math.min(dp[index-1], dp[index-2]);
            }
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);

    }
}
