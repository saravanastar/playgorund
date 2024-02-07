package com.ask.workout.algo.leetcode;

public class MaxConsecutiveOneII {

    public static void main(String[] args) {
        MaxConsecutiveOneII maxConsecutiveOneII = new MaxConsecutiveOneII();
        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 0, 1, 0}));
        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 0, 1, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        int zeroCounter = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zeroCounter == 1) {
                    result = Math.max((right-left), result);
                    left = right;
                    right++;
                } else {
                    zeroCounter++;
                    right++;
                }
            } else {
                right++;
            }
        }
        result = Math.max((right-left) , result);
        return result;

    }

    /**
     * input : 1, 0, 1, 1, 0
     */

}
