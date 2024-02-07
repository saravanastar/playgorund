package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] input1 = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] input2 = new int[]{4,2,0,3,2,5};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(input1));
        System.out.println(trappingRainWater.trap(input2));
    }

    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int currentMax = Integer.MIN_VALUE;
        for (int index = height.length -1; index >= 0; index--) {
            currentMax = Math.max(currentMax, height[index]);
            maxRight[index] = currentMax;
        }

        int currentIndex = 0;
        int maxLeft = Integer.MIN_VALUE;
        int waterQuan = 0;
        while (
                currentIndex < height.length
        ) {
            maxLeft = Math.max(maxLeft, height[currentIndex]);
            waterQuan+=Math.min(maxLeft, maxRight[currentIndex]) - height[currentIndex];
            currentIndex++;
        }
        return waterQuan;
    }
}
