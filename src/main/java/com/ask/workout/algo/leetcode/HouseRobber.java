package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/house-robber/description
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{1,2,3,1}));
        System.out.println(houseRobber.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            if (index < 2) {
                dp[index] = nums[index];
            } else {
                dp[index] = Math.max(dp[index-1], dp[index-2] + nums[index]);
            }
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}
