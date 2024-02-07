package com.ask.workout.algo.leetcode2;


/**
 * https://leetcode.com/problems/invert-binary-tree/submissions/612360229/
 */
public class InvertBinaryTree {

    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode root, TreeNode left, TreeNode right) {

    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

}
