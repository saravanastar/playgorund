package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description
 */
public class MaximumLevelSumBT {

    public static void main(String[] args) {
        MaximumLevelSumBT maximumLevelSumBT = new MaximumLevelSumBT();
//        System.out.println(maximumLevelSumBT.maxLevelSum(TreeUtil.buildTree(new Integer[]{1,7,0,7,-8,null,null})));
        System.out.println(maximumLevelSumBT.maxLevelSum(TreeUtil.buildTree(new Integer[]{-100,-200,-300,-20,-5,-10,null})));
    }
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.push(root);
        int maxLevel  = 0;
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int index = 0; index < size; index++) {
                TreeNode pop = queue.removeLast();

                if (pop.right != null) {
                    queue.push(pop.right);
                }
                if (pop.left != null) {
                    queue.push(pop.left);
                }
                sum+=pop.val;

            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;

        }
        return maxLevel;
    }
}
