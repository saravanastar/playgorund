package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

/**
 * https://leetcode.com/problems/path-sum-iii/description
 */
public class PathSumIII {

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{-2, null, -3}), -2));
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{1}), 0));
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{-2, null, -3}), -5));
        System.out.println(pathSumIII.pathSum(TreeUtil.buildTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1}), 3));
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int counter = 0;
        counter += pathSum(root, 0, targetSum);
        counter += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        return counter;
    }

    public int pathSum(TreeNode root, long actualSum, int targetSum) {
        int counter = 0;
        if (root == null) {
            return 0;
        }
        actualSum = actualSum + root.val;
        if (targetSum == actualSum) {
            counter++;
        }


        counter += pathSum(root.left, actualSum, targetSum) + pathSum(root.right, actualSum, targetSum);
        return counter;
    }
}
