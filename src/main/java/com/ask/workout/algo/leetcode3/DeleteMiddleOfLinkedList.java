package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.ListNode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description
 */
public class DeleteMiddleOfLinkedList {

    public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(3);
            head.next.next = new ListNode(4);
            head.next.next.next = new ListNode(7);
            head.next.next.next.next = new ListNode(1);
            head.next.next.next.next.next = new ListNode(2);
            head.next.next.next.next.next.next = new ListNode(6);

            DeleteMiddleOfLinkedList deleteMiddleOfLinkedList = new DeleteMiddleOfLinkedList();

            ListNode result = deleteMiddleOfLinkedList.deleteMiddle(head);
            while (result != null) {
                System.out.print(result.val);
                result = result.next;
            }

    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
