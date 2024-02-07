package com.ask.workout.algo.leetcode;

public class MaxConsecutiveOneIII {

    public static void main(String[] args) {
        MaxConsecutiveOneIII maxConsecutiveOneII = new MaxConsecutiveOneIII();
//        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}, 2));
//        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 0, 1, 0}, 2));
//        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 0, 1, 1}, 2));
        System.out.println(maxConsecutiveOneII.findMaxConsecutiveOnes(new int[]{1, 0, 0, 0,1,1, 1}, 2));
    }

    public int findMaxConsecutiveOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int zeroCounter = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCounter++;
            }
            while (zeroCounter > k) {
                if (nums[left] == 0) {

                    zeroCounter--;
                }
                left++;
            }
            result = Math.max((right - left) + 1, result);
            right++;
        }
        return result;

    }

    /**
     * input : 1, 0, 1, 1, 0
     */

}
