package com.ask.workout.algo.leetcode3;


import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/leaf-similar-trees
 */
public class LeafSimilarTrees {


    public static void main(String[] args) {
//        TreeNode root1 = TreeUtil.buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
//        TreeNode root2 = TreeUtil.buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();

        TreeNode root1 = TreeUtil.buildTree(new Integer[]{1,2,3});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{1,3,2});
        System.out.println(leafSimilarTrees.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaf = new ArrayList<>();
        List<Integer> root2Leaf = new ArrayList<>();
        getLeafNodes(root1, root1Leaf);
        getLeafNodes(root2, root2Leaf);

        if (root1Leaf.size() != root2Leaf.size()) {
            return false;
        }
        for (int index = 0; index < root1Leaf.size(); index++) {
            if (!Objects.equals(root1Leaf.get(index), root2Leaf.get(index))) {
                return false;
            }
        }
        return true;
    }

    public void getLeafNodes(TreeNode node, List<Integer> leafs) {

        if (node == null) {
            return;
        }

        if (node.left == null &&  node.right == null) {
            leafs.add(node.val);
            return;
        }


        getLeafNodes(node.left, leafs);

         getLeafNodes(node.right, leafs);

    }
}
