package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/move-zeroes/description
 */
public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        int nonZeroPositions = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                nums[nonZeroPositions++] = nums[index];
            }
        }
        for (int index = nonZeroPositions; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
