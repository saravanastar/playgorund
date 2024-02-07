package com.ask.workout.algo.leetcode2;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor commonAncestor = new LowestCommonAncestor();
        TreeNode root = TreeUtil.buildTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeUtil.printBFS(root);
//        TreeNode response1 = commonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        TreeNode response2 = commonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println();
//        if (response1 != null) System.out.println(response1.val);
        if (response2 != null) System.out.println(response2.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            TreeNode currentNode = bfs.poll();
            if ((p.val <= currentNode.val && q.val >= currentNode.val) || (q.val <= currentNode.val && p.val >= currentNode.val)) {
                return currentNode;
            }
            if (currentNode.left != null) bfs.push(currentNode.left);
            if (currentNode.right != null) bfs.push(currentNode.right);
        }
        return null;
    }



}
