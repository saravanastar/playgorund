package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/container-with-most-water
 */
public class ContainsMostWater {

    public static void main(String[] args) {
        ContainsMostWater containsMostWater = new ContainsMostWater();
        System.out.println(containsMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(containsMostWater.maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while (leftIndex < rightIndex) {
            int min = Math.min(height[leftIndex], height[rightIndex]);
            int posDiff = rightIndex - leftIndex;
            max = Math.max(max, (min*posDiff));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }

        }
        return max;
    }
}
