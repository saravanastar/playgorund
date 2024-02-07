package com.ask.workout.algo.leetcode2;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode listNode1 = mergeTwoSortedList.new ListNode(1);
        listNode1.next = mergeTwoSortedList.new ListNode(2);
        listNode1.next.next = mergeTwoSortedList.new ListNode(4);

        ListNode listNode2 = mergeTwoSortedList.new ListNode(1);
        listNode2.next = mergeTwoSortedList.new ListNode(3);
        listNode2.next.next = mergeTwoSortedList.new ListNode(4);

        ListNode result = mergeTwoSortedList.mergeTwoLists(mergeTwoSortedList.new ListNode(2), mergeTwoSortedList.new ListNode(1));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2== null) return null;
        if (list1 == null || list2 == null) {
            if (list2 != null) return list2;
            if (list1 != null) return list1;
            return null;
        }
        ListNode head = list1;
        ListNode currentList2 = list2;
        ListNode currentList1 = list1;
        while (currentList1 != null && currentList2 != null) {
            if (currentList1.val == currentList2.val) {
                ListNode temp = currentList2.next;
                currentList2.next = currentList1.next;
                currentList1.next = currentList2;
               currentList2 = temp;
            } else if (currentList1.val < currentList2.val) {
                while (currentList1.next != null && currentList2.val > currentList1.next.val) {
                    currentList1 = currentList1.next;
                }
                ListNode temp = currentList2.next;
                currentList2.next = currentList1.next;
                currentList1.next = currentList2;
                currentList2 = temp;
            } else {
                if (currentList1 == head) {
                    ListNode temp = currentList2.next;
                    currentList2.next = currentList1;
                    head = currentList2;
                    currentList1 = head;
                    currentList2 = temp;
                }
            }
        }
        if (currentList2 != null) {
            while (currentList1.next != null) {
                currentList1 = currentList1.next;
            }
            currentList1.next = currentList2;
        }
        return head;
    }
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    
}
