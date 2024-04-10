package com.ask.workout.algo.util;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class TreeUtil {

    public static TreeNode buildTree(Integer[] array) {

       if (array.length > 0) {
           TreeNode root = new TreeNode(array[0]);
           create(root, array, 0);
           return root;
       }
       return null;
    }

    public static void printBFS(TreeNode node) {
        Deque<TreeNode> container = new LinkedList<>();
        if (node != null) {
            container.add(node);
        }
        while (!container.isEmpty()) {
            int maxSize = container.size();
            int currentSize = 0;
            while (currentSize < maxSize) {
                TreeNode current = container.pollLast();
                System.out.print(current.val + "\t");

                if (current.left != null) {
                    container.push(current.left);
                }
                if (current.right != null) {
                    container.push(current.right);
                }
                currentSize++;
            }
            System.out.println();

        }
    }

    private  static void create(TreeNode root, Integer[] array, int rootIndex) {
        if (root == null) return;
        if (rootIndex > array.length-1) return;
        int leftIndex = findLeftChild(rootIndex);
        int rightIndex = findRightChild(rootIndex);
        if (leftIndex < array.length && array[leftIndex] != null) {
            root.left = new TreeNode(array[leftIndex]);
            create(root.left, array, leftIndex);
        }
        if (rightIndex < array.length && array[rightIndex] != null) {
            root.right = new TreeNode(array[rightIndex]);
            create(root.right, array, rightIndex);
        }
    }

    private static int findLeftChild(int index) {
        return 2 * index + 1;
    }

    private static int findRightChild(int index) {
        return 2 * index + 2;
    }

    private static int findRoot(int index) {
        return  index/2 - 1;
    }
}


