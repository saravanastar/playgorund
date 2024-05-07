package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description
 */
public class BTRightSideView {

    public static void main(String[] args) {
        BTRightSideView btRightSideView = new BTRightSideView();
//        System.out.println(btRightSideView.rightSideView(TreeUtil.buildTree(new Integer[]{1,2,3,4})));
        System.out.println(btRightSideView.rightSideView(TreeUtil.buildTree(new Integer[]{1,2,3,null,5,null,4})));
//        System.out.println(btRightSideView.rightSideView(TreeUtil.buildTree(new Integer[]{1,null,2,null,null,5,4,6,3})));
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.left.left = new TreeNode(3);
        root.right.right.right = new TreeNode(6);
//        System.out.println(btRightSideView.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                TreeNode pop = queue.removeLast();
                if (index == 0) {
                    result.add(pop.val);
                }
                if (pop.right != null) {
                    queue.push(pop.right);
                }
                if (pop.left != null) {
                    queue.push(pop.left);
                }

            }

        }
        return result;

    }
}
