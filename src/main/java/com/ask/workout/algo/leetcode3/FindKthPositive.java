package com.ask.workout.algo.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class FindKthPositive {

    public static void main(String[] args) {
        FindKthPositive findKthPositive = new FindKthPositive();
        System.out.println(findKthPositive.findKthPositive(new int[]{2,3,4,7,11}, 5));
//        System.out.println(findKthPositive.findKthPositive(new int[]{1,2,3,4}, 2));
        System.out.println(findKthPositive.findKthPositive(new int[]{2}, 1));
    }

    public int findKthPositive(int[] arr, int k) {
        int currentMissingCount = 0;
        Set<Integer> integerSet = new HashSet<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                currentMissingCount = arr[index] - (index+1);
            }
            integerSet.add(arr[index]);
        }
        if (currentMissingCount < k) {
            return arr[arr.length-1] + (k-currentMissingCount);
        }

        int startFrom = arr[arr.length-1];
        while (currentMissingCount >= k) {
           if (!integerSet.contains(startFrom)) {
               currentMissingCount--;
           }
           startFrom--;
        }
        return startFrom+1;
    }
}
