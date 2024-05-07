package com.ask.workout.algo.leetcode3;
import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

public class LongestZigzagPath {


    public static void main(String[] args) {
        LongestZigzagPath longestZigzagPath = new LongestZigzagPath();
//        System.out.println(longestZigzagPath.longestZigZag(TreeUtil.buildTree(new Integer[]{1,null,1, null, null,1,1,null,null,1,1,null,1,null,null,null,1})));
//        System.out.println(longestZigzagPath.longestZigZag(TreeUtil.buildTree(new Integer[]{1,1,1,null,1,null,null,1,1,null,1})));
        TreeNode root2 = example2();
        TreeNode root1 = example1();
//        System.out.println(longestZigzagPath.longestZigZag(root2));
        System.out.println(longestZigzagPath.longestZigZag(root1));
    }

    private static TreeNode example1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);

        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        return root;
    }

    private static TreeNode example2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        return root;
    }
    int counter = 0;
    public int longestZigZag(TreeNode root) {
         counter = 0;
        if (root == null) {
            return 0;
        }
        longestZigZag(root.left, true, 1);
        longestZigZag(root.right, false, 1);
//        counter = Math.max(longestZigZag(root.left), counter);
//        counter = Math.max(longestZigZag(root.right), counter);
        return counter;
    }

    public void longestZigZag(TreeNode root, boolean zigzag, int count) {
       if (root == null) {
           return;
       }
       counter = Math.max(count, counter);

        longestZigZag(root.left, true,  zigzag ? 1 : count+1);
        longestZigZag(root.right, false,  zigzag ? count+1 : 1);


    }
}
