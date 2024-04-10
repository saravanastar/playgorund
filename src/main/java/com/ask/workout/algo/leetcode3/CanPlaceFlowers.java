package com.ask.workout.algo.leetcode3;

/**
 * https://leetcode.com/problems/can-place-flowers
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers placeFlowers = new CanPlaceFlowers();
//        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 1));
//        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
//        System.out.println(placeFlowers.canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
//        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{0,1,0,1,0,1,0,0}, 1));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return canPlaceFlowers(flowerbed, n, 0);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n, int currentIndex) {
        if (n ==0) {
            return true;
        }
        if (currentIndex > flowerbed.length-1) {
            return false;
        }
        if (flowerbed[currentIndex] == 1) {
            return canPlaceFlowers(flowerbed, n, currentIndex+2);
        }

        if (flowerbed[currentIndex] == 0 && (currentIndex ==0 || flowerbed[currentIndex-1] == 0) && (currentIndex  == flowerbed.length-1  || flowerbed[currentIndex+1] == 0)) {
            return canPlaceFlowers(flowerbed, n-1, currentIndex+2);
        }


        return canPlaceFlowers(flowerbed, n, currentIndex+1);
    }

}
