package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
//        ListNode node1 =  new ListNode(1);
//        node1.next =  new ListNode(4);
//        node1.next.next =  new ListNode(5);
//
//        ListNode node2 =  new ListNode(1);
//        node2.next =  new ListNode(3);
//        node2.next.next =  new ListNode(4);
//
//        ListNode node3 =  new ListNode(2);
//        node3.next =  new ListNode(6);
//
//        ListNode[] listNodes = {node1, node2, node3};

        ListNode node1 =  new ListNode(-2);
        node1.next =  new ListNode(-1);
        node1.next.next =  new ListNode(-1);
        node1.next.next.next =  new ListNode(-1);

        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = node1;
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode result = mergeKSortedList.mergeKLists(listNodes);

        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode listNode :
                lists) {
            ListNode currentNode = listNode;
            while (currentNode != null) {
                listNodes.offer(currentNode);
                currentNode = currentNode.next;
            }

        }
        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        while (!listNodes.isEmpty()) {
            ListNode tempNode = listNodes.poll();
            currentNode.next = tempNode;
            currentNode = currentNode.next;
        }
        currentNode.next = null;

        return dummyNode.next;

    }

    private ListNode mergeTwoNodes(ListNode left, ListNode right) {
        ListNode currentLeft = left;
        ListNode currentRight = right;
        ListNode prevNode = null;
        while (currentLeft != null && currentRight != null) {
            if (currentLeft.val < currentRight.val) {
                prevNode = currentLeft;
                currentLeft.next = currentLeft;
            } else {
                if (prevNode != null) {
                    prevNode.next = currentRight;
                } else {
                    prevNode = currentRight;
                }
                currentRight.next = currentLeft;
                currentRight = currentRight.next;
            }
        }

        if (currentRight != null) {
            currentLeft.next = currentRight;
        }

        currentLeft = moveNeedleToTail(currentLeft);

        return currentLeft;

    }

    private static ListNode moveNeedleToTail(ListNode currentLeft) {
        while (currentLeft != null && currentLeft.next != null) {
            currentLeft = currentLeft.next;
        }
        return currentLeft;
    }
}
