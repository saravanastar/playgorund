package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     *   [-2,1,-3,4,-1,2,1,-5,4]
     *
     *
     */


    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        while (currentIndex < nums.length) {
            currentSum = currentSum + nums[currentIndex];
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum < 0) {
                currentSum = 0;
            }
            currentIndex++;
        }
        return maxSum;

    }
}
