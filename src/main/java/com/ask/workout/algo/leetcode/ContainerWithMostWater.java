package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] input2 = new int[]{1,1};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(input1));
        System.out.println(containerWithMostWater.maxArea(input2));
    }


    public int maxArea(int[] height) {
        int totalLength = height.length;
        if (totalLength <= 1) return -1;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = totalLength-1;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, currentHeight * width);
            if (height[left] < height[right]) {
                left+=1;
            } else {
                right-=1;
            }
        }
        return max;
    }
}


/**
 *
 */