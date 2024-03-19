package com.ask.workout.algo.leetcode3;

import java.util.PriorityQueue;

public class KthElement {
    public static void main(String[] args) {
        KthElement element = new KthElement();
        System.out.println(element.kthElement(new int[]{1, 2, 5, 9}, 3));
    }

    public int kthElement(int[] input, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int number :
                input) {
            queue.offer(number);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
