package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 2, 5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 1}));
    }


    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num :
                nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        totalSum = totalSum / 2;
        Boolean[][] lookup = new Boolean[nums.length + 1][totalSum + 1];

        return partitionAndCompare(nums, totalSum, nums.length, lookup);
    }

    public boolean partitionAndCompare(int[] nums, int sum, int currentIndex, Boolean[][] lookup) {
        if (currentIndex == 0 || sum < 0) {
            return false;
        }
        if (lookup[currentIndex][sum] != null) {
            return lookup[currentIndex][sum];
        }

        if (sum == 0) {
            return true;
        }
        return lookup[currentIndex][sum] = partitionAndCompare(nums, sum - nums[currentIndex - 1], currentIndex - 1, lookup) ||
                partitionAndCompare(nums, sum, currentIndex - 1, lookup);
    }
}
