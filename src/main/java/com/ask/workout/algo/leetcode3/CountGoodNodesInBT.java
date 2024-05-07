package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description
 */
public class CountGoodNodesInBT {

    public static void main(String[] args) {
        CountGoodNodesInBT countGoodNodesInBT = new CountGoodNodesInBT();
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{3,1,4,3,null,1,5});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{3,3,null,4,2});
        TreeNode root3 = TreeUtil.buildTree(new Integer[]{9,null,3,6});
        System.out.println(countGoodNodesInBT.goodNodes(root1));
        System.out.println(countGoodNodesInBT.goodNodes(root2));
        System.out.println(countGoodNodesInBT.goodNodes(root3));

    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode node, int rootVal) {
        if ( node == null) {
            return 0;
        }
        int goodNode = 0;
        if (node.val >= rootVal) {
            goodNode =  1;
        }
        int val = goodNode == 1 ? node.val: rootVal;

        return goodNode + goodNodes(node.left, val) + goodNodes(node.right, val);
    }
}
