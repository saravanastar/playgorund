package com.ask.workout.algo.leetcode2;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
//        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 2));
//        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 0));
        System.out.println(search.search(new int[]{5}, 5));
    }

    public int search(int[] nums, int target) {
      return binarySearch(nums, 0, nums.length -1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
       if (left <= right) {
           int mid = left + (right - left) / 2;

           if (nums[mid] == target) return mid;

           if (target < nums[mid]) {
               return binarySearch(nums, left, mid - 1, target);
           } else {
               return binarySearch(nums, mid + 1, right, target);
           }
       }
       return -1;

    }
}
