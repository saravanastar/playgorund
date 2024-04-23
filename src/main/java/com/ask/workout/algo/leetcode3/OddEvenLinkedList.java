package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(head);

        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        if (odd != null) {
            odd.next = evenHead;
        }
        return head;
    }
}
