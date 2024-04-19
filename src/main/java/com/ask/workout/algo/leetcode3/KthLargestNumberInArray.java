package com.ask.workout.algo.leetcode3;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestNumberInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int index = 0; index < nums.length; index++) {
            queue.offer(nums[index]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestNumberInArray kthLargestNumberInArray = new KthLargestNumberInArray();
        System.out.println(kthLargestNumberInArray.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(kthLargestNumberInArray.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
