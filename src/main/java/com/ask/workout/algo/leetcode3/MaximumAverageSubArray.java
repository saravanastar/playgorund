package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i
 */
public class MaximumAverageSubArray {
    public static void main(String[] args) {
        MaximumAverageSubArray maximumAverageSubArray = new MaximumAverageSubArray();
//        System.out.println(maximumAverageSubArray.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
//        System.out.println(maximumAverageSubArray.findMaxAverage(new int[]{5}, 1));
        System.out.println(maximumAverageSubArray.findMaxAverage(new int[]{-1}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int currentSum = 0;
        double maxAverage = -Double.MAX_VALUE;
        while(rightIndex < n) {
            while (rightIndex < nums.length && (rightIndex-leftIndex + 1) <= k) {
                currentSum+=nums[rightIndex];
                rightIndex++;
            }
            maxAverage = Math.max(maxAverage, (double) currentSum /k);
            currentSum-=nums[leftIndex++];
        }
        return maxAverage;
    }
}
