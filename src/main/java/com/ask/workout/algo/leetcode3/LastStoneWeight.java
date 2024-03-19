package com.ask.workout.algo.leetcode3;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/description/
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{1}));
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,2}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num :
                stones) {
            queue.offer(num);
        }
        while (!queue.isEmpty() && queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            if (num2 != num1) {
                queue.offer(Math.abs(num2-num1));
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
