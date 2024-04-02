package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        System.out.println(linkedListCycle.hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow.val == fast.val) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
