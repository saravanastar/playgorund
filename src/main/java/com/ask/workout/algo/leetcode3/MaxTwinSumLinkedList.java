package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description
 */
public class MaxTwinSumLinkedList {

    public int pairSum(ListNode head) {
        int max = 0;
        List<Integer> lookup = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            lookup.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int n = lookup.size();
        int calculateIndex = (n/2);

        for (int index = calculateIndex; index < n; index++) {
            int pairIndex = n -1 - index;
            int sum = lookup.get(pairIndex) + lookup.get(index);
            max = Math.max(max, sum);
        }
        return max;
    }
}
