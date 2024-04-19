package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
//        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0, 0}, 0));
    }


    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        int currentZeros = 0;

        while (rightIndex < nums.length) {
            if (nums[rightIndex] == 0) {
                currentZeros++;
            }
            while (leftIndex < rightIndex && currentZeros > k) {
                int val = nums[leftIndex];
                if (val == 0) {
                    currentZeros--;
                }
                leftIndex++;
            }
            if (currentZeros <= k) {
                max = Math.max(max, (rightIndex - leftIndex + 1));
            }
            rightIndex++;
        }
        return max;
    }


}
