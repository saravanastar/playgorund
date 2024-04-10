package com.ask.workout.algo.ds;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;


/**
 *
 *  A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.
 *
 *
 * https://cdn.programiz.com/sites/tutorial2program/files/perfect-binary-tree_0.png
 *
 *
 *
 * A perfect binary tree of height h has 2h + 1 – 1 node.
 * A perfect binary tree with n nodes has height log(n + 1) – 1 = Θ(ln(n)).
 * A perfect binary tree of height h has 2h leaf nodes.
 * The average depth of a node in a perfect binary tree is Θ(ln(n)).
 */
public class PerfectBinaryTree {

    public boolean isPerfectBinaryTree(TreeNode node, int totalDepth, int currentLevel) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return totalDepth == currentLevel;
        }

        if (node.left == null || node.right == null) {
            return false;
        }

        return isPerfectBinaryTree(node.left, totalDepth, currentLevel+1) &&
                isPerfectBinaryTree(node.right, totalDepth, currentLevel+1);

    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + depth(node.left);
    }

    public static void main(String[] args) {
        Integer[] input1 = {1,2,3,4,5,null, null,null, null,6,7};
        Integer[] input2 = {1,2,3,4,5,6,7};
        PerfectBinaryTree perfectBinaryTree = new PerfectBinaryTree();
        System.out.println(perfectBinaryTree.isPerfectBinaryTree(TreeUtil.buildTree(input1), perfectBinaryTree.depth(TreeUtil.buildTree(input1)),1 ));
        System.out.println(perfectBinaryTree.isPerfectBinaryTree(TreeUtil.buildTree(input2), perfectBinaryTree.depth(TreeUtil.buildTree(input2)),1 ));
    }
}
