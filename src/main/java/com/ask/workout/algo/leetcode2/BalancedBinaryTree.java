package com.ask.workout.algo.leetcode2;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
//        System.out.println(balancedBinaryTree.isBalanced(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7})));
//        System.out.println(balancedBinaryTree.isBalanced(TreeUtil.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4})));
        System.out.println(balancedBinaryTree.isBalanced(TreeUtil.buildTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4})));
        System.out.println(balancedBinaryTree.isBalancedOn(TreeUtil.buildTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4})));
    }

    /**
     * o(n2) solution
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        Deque<TreeNode> lookup = new LinkedList<>();
        lookup.push(root);
        while (!lookup.isEmpty()) {
            TreeNode currentNode = lookup.poll();
            TreeNode leftNode = currentNode.left;
            TreeNode rightNode = currentNode.right;
            int count = Math.abs(count(leftNode) - count(rightNode));
            if (count > 1) return false;
            if (leftNode != null) lookup.push(leftNode);
            if (rightNode != null) lookup.push(rightNode);
        }


        return true;
    }

    /**
     * o(n) solution
     * @param root
     * @return
     */
    public boolean isBalancedOn(TreeNode root) {

        if (root == null) return true;



        return isBalancedOn(root.left) && isBalancedOn(root.right) && Math.abs(count(root.left) - count(root.right)) <=1;
    }

    public int count(TreeNode node) {
        if (node == null) return 0;

        int leftCount = count(node.left);
        int rightCount = count(node.right);
        return 1 + Math.max(leftCount, rightCount);
    }


}
