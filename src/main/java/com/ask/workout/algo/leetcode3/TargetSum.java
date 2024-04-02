package com.ask.workout.algo.leetcode3;


/**
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] input1 = {1, 1, 1, 1, 1};
        int[] input2 = {1};
        int[] input3 = {1};
        int[] input4 = {0,0,0,0,0,0,0,0,1};
        System.out.println(targetSum.findTargetSumWays(input1, 3));
        System.out.println(targetSum.findTargetSumWays(input2, 1));
        System.out.println(targetSum.findTargetSumWays(input3, 2));
        System.out.println(targetSum.findTargetSumWays(input4, 1));
    }


    Integer[][] lookup;
    int totalSum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int index = 0; index < nums.length;index++) {
            totalSum+= nums[index];
        }
        lookup = new Integer[nums.length+1][2*totalSum+1];
        return ways(nums, target, nums.length-1, 0);
    }

    public int ways(int[] nums, int target, int currentIndex, int currentSum) {

        if (currentIndex < 0) {
            if(currentSum == target) {
                return 1;
            }
            return 0;
        }
        if (lookup[currentIndex][currentSum + totalSum] != null) {
            return lookup[currentIndex][currentSum + totalSum];
        }

        return lookup[currentIndex][currentSum + totalSum] = ways(nums, target, currentIndex - 1, currentSum + nums[currentIndex]) +
                ways(nums, target, currentIndex - 1, currentSum - nums[currentIndex]);

    }
}
