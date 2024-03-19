package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumberLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ll1 = new ListNode(9);
        ll1.next = new ListNode(9);
        ll1.next.next = new ListNode(9);
        ll1.next.next.next = new ListNode(9);
        ll1.next.next.next.next = new ListNode(9);
        ll1.next.next.next.next.next = new ListNode(9);
        ll1.next.next.next.next.next.next = new ListNode(9);

        ListNode ll2 = new ListNode(9);
        ll2.next = new ListNode(9);
        ll2.next.next = new ListNode(9);
        ll2.next.next.next = new ListNode(9);

        AddTwoNumberLinkedList addTwoNumberLinkedList = new AddTwoNumberLinkedList();
        ListNode result = addTwoNumberLinkedList.addTwoNumbers(ll1, ll2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carrier = 0;
        while (l1 != null && l2!= null) {
            int sum = l1.val + l2.val + carrier;
            int remainder = sum%10;
            carrier = sum/10;
            ListNode listNode = new ListNode(remainder);
            temp.next = listNode;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carrier;
            int remainder = sum%10;
            carrier = sum/10;
            ListNode listNode = new ListNode(remainder);
            temp.next = listNode;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carrier;
            int remainder = sum%10;
            carrier = sum/10;
            ListNode listNode = new ListNode(remainder);
            temp.next = listNode;
            temp = temp.next;
            l2 = l2.next;
        }
        if (carrier > 0) {
            ListNode listNode = new ListNode(carrier);
            temp.next = listNode;
            temp = temp.next;
        }
        return dummy.next;

    }
}
