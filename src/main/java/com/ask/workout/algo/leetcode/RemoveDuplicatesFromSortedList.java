package com.ask.workout.algo.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
//        ListNode head = removeDuplicatesFromSortedList.new ListNode(1);
//        head.next = removeDuplicatesFromSortedList.new ListNode(2);
//        head.next.next = removeDuplicatesFromSortedList.new ListNode(3);
//        head.next.next.next  = removeDuplicatesFromSortedList.new ListNode(3);
//        head.next.next.next.next   = removeDuplicatesFromSortedList.new ListNode(4);
//        head.next.next.next.next.next   = removeDuplicatesFromSortedList.new ListNode(4);
//        head.next.next.next.next.next.next  = removeDuplicatesFromSortedList.new ListNode(5);

        ListNode head = removeDuplicatesFromSortedList.new ListNode(1);
        head.next = removeDuplicatesFromSortedList.new ListNode(1);
        head.next.next = removeDuplicatesFromSortedList.new ListNode(1);
        head.next.next.next  = removeDuplicatesFromSortedList.new ListNode(2);
        head.next.next.next.next   = removeDuplicatesFromSortedList.new ListNode(3);
        head.next.next.next.next.next   = removeDuplicatesFromSortedList.new ListNode(4);
//        head.next.next.next.next.next.next  = removeDuplicatesFromSortedList.new ListNode(5);

        ListNode result = removeDuplicatesFromSortedList.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevNode = dummy;
        while (currentNode != null) {
            if (currentNode.next != null && currentNode.val == currentNode.next.val) {
                while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                    currentNode = currentNode.next;
                }
                prevNode.next = currentNode.next;
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return dummy.next;
    }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
