package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence
 */
public class IncreasingTripletSubsequence {


    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= firstMin) {
                firstMin = num;
            } else  if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * n factorial time
     */
    public boolean triplet(int[] nums, int fixed, int left, int right) {
        if (left == right) {
            return false;
        }
        if (left > nums.length-2 || right > nums.length-1) {
            return false;
        }
        if (nums[fixed] < nums[left] && nums[left] < nums[right]) {
            return true;
        }

        return triplet(nums, fixed, left, right + 1) || triplet(nums, fixed, left+1, left+2);
    }

}
