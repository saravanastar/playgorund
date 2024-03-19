package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] height) {
       int[] leftMax = new int[height.length];
       int[] rightMax = new int[height.length];
       int currentMax = 0;
        for (int index = 0; index < height.length; index++) {
            currentMax = Math.max(currentMax, height[index]);
            leftMax[index] = currentMax;
        }

        currentMax = 0;
        for (int index = height.length-1; index >= 0; index--) {
            currentMax = Math.max(currentMax, height[index]);
            rightMax[index] = currentMax;
        }
        int water = 0;
        for (int index = 0; index < height.length; index++) {
            water+= Math.min(leftMax[index], rightMax[index]) - height[index];
        }
        return water;
    }

    public int trap2(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    }
}
