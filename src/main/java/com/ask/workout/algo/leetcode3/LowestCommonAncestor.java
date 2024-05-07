package com.ask.workout.algo.leetcode3;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p1 = new TreeNode(5);
        TreeNode q1 = new TreeNode(1);

        TreeNode root2 = TreeUtil.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p2 = new TreeNode(5);
        TreeNode q2 = new TreeNode(4);

        TreeNode root3 = TreeUtil.buildTree(new Integer[]{1, 2});
        TreeNode p3 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);


        LowestCommonAncestor commonAncestor = new LowestCommonAncestor();
        System.out.println(commonAncestor.lowestCommonAncestor(root1, p1, q1).val);
        System.out.println(commonAncestor.lowestCommonAncestor(root2, p2, q2).val);
        System.out.println(commonAncestor.lowestCommonAncestor(root3, p3, q3).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val == root.val || root.val == q.val) {
            return root;
        }

       TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
       TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
       if (leftNode != null && rightNode != null) {
           return root;
       }
       if (leftNode == null) {
           return rightNode;
       }

       return leftNode;

    }
}
