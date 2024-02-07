package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class FindMaxOnes {
    public static void main(String[] args) {
        FindMaxOnes findMaxOnes = new FindMaxOnes();
        System.out.println(findMaxOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {

        int left = 0, right = 0;
        int result = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                while (right +1 < nums.length && nums[right+1] == 1) {
                    right++;
                }
                result = Math.max(result, (right-left) + 1);
                left++;
                right++;
            } else {
                right++;
                left = right;

            }
        }
        return result;
    }
}
