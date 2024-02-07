package com.ask.workout.algo.leetcode2;
import com.ask.workout.algo.util.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/submissions/612188900/
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) return true;
            slowNode = slowNode.next;
            if (fastNode.next == null) return false;
            fastNode = fastNode.next.next;
        }
        return false;
    }
    
}

