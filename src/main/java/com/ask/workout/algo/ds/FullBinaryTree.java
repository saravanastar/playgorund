package com.ask.workout.algo.ds;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

/**
 * A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.
 *
 * It is also known as a proper binary tree.
 *
 * https://cdn.programiz.com/sites/tutorial2program/files/full-binary-tree_0.png
 *
 *
 * Let, i = the number of internal nodes
 *        n = be the total number of nodes
 *        l = number of leaves
 *       λ = number of levels
 *
 *
 * The number of leaves is i + 1.
 * The total number of nodes is 2i + 1.
 * The number of internal nodes is (n – 1) / 2.
 * The number of leaves is (n + 1) / 2.
 * The total number of nodes is 2l – 1.
 * The number of internal nodes is l – 1.
 * The number of leaves is at most 2λ - 1.
 *
 */
public class FullBinaryTree {

    public boolean isFullBinaryTree(TreeNode node) {

        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }


        return  false;
    }

    public static void main(String[] args) {
        Integer[] input1 = {1,2,3,4,5,null, null,null, null,6,7};
        Integer[] input2 = {1,2,3,4,5,null, null,null, null,6,null};
        FullBinaryTree fullBinaryTree = new FullBinaryTree();
        System.out.println(fullBinaryTree.isFullBinaryTree(TreeUtil.buildTree(input1)));
        System.out.println(fullBinaryTree.isFullBinaryTree(TreeUtil.buildTree(input2)));
    }
}
