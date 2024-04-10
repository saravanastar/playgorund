package com.ask.workout.algo.ds;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

/**
 * A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one, which is filled from the left.
 *
 *
 * https://cdn.programiz.com/sites/tutorial2program/files/complete-binary-tree_0.png
 *
 *
 * A complete binary tree is just like a full binary tree, but with two major differences
 *
 * All the leaf elements must lean towards the left.
 * The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.
 */
public class CompleteBinaryTree {


    public boolean isCompleteBinaryTree(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right != null) {
            return false;
        }

        return isCompleteBinaryTree(node.left) && isCompleteBinaryTree(node.right);
    }

    public static void main(String[] args) {
        Integer[] input1 = {1,2,3,4,5,null, 7};
        Integer[] input2 = {1,2,3,4,5,6,null};
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        System.out.println(completeBinaryTree.isCompleteBinaryTree(TreeUtil.buildTree(input1)));
        System.out.println(completeBinaryTree.isCompleteBinaryTree(TreeUtil.buildTree(input2)));
    }
}
