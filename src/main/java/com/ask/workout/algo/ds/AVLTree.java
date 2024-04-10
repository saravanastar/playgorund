package com.ask.workout.algo.ds;

import com.ask.workout.algo.util.TreeNode;
import com.ask.workout.algo.util.TreeUtil;

public class AVLTree {

    TreeNode root;

    public TreeNode rotateRight(TreeNode node) {
        TreeNode leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    public TreeNode rotateLeft(TreeNode node) {
        TreeNode rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void updateHeight(TreeNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    public int balanceFactor(TreeNode node) {
        return height(node.right) - height(node.left);
    }

    public TreeNode rebalance(TreeNode node) {
        int balanceFactor = balanceFactor(node);

        // right heavy
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >=0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        // left heavy
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <=0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.right);
                node = rotateRight(node);
            }
        }

        return node;
    }

    public TreeNode insert(int val) {
        TreeNode node = this.insertNode(root, val);

        if (root == null) {
            root = node;
        }

        updateHeight(node);
        return rebalance(node);
    }

    public TreeNode delete(int val) {
        TreeNode node = deleteNode(val, root);
        updateHeight(node);
        return rebalance(node);
    }
    public TreeNode deleteNode(int val, TreeNode node) {
        if (node == null) {
            return null;
        }

        if (val == node.val) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            TreeNode smallest = node.right;
            TreeNode currentNode = node.right;
            while (currentNode != null) {
                if (currentNode.val < smallest.val) {
                    smallest = currentNode;
                }
                currentNode = currentNode.left;
            }
            node.val = smallest.val;
            node.right = this.deleteNode(smallest.val, node.right);

            return node;

        } else if (val < node.val) {
            node.left = deleteNode(val, node.left);
        } else {
            node.right = deleteNode(val, node.right);
        }

        return node;
    }

    public TreeNode insertNode(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        }else if (val < node.val) {
            node.left = insertNode(node.left, val);
        } else if (val > node.val) {
            node.right = insertNode(node.right, val);
        }

        updateHeight(node);


        return rebalance(node);
    }

    public void print() {
        TreeUtil.printBFS(root);
        System.out.println();
    }


    public static void main(String[] args) {
//        AVLTree avlTree = new AVLTree();
//
//        avlTree.root = avlTree.insert(10);
//        avlTree.root = avlTree.insert(20);
//        avlTree.root =  avlTree.insert(30);
//        avlTree.root =  avlTree.insert(40);
//        avlTree.root =  avlTree.insert(50);
//        avlTree.root =  avlTree.insert(25);
//        avlTree.print();

        AVLTree avlTree = new AVLTree();

        avlTree.root = avlTree.insert(13);
        avlTree.root = avlTree.insert(10);
        avlTree.root =  avlTree.insert(15);
        avlTree.root =  avlTree.insert(5);
        avlTree.root =  avlTree.insert(11);
        avlTree.root =  avlTree.insert(16);
        avlTree.root =  avlTree.insert(4);
        avlTree.root =  avlTree.insert(8);
        avlTree.root =  avlTree.insert(3);
        avlTree.root =  avlTree.insert(2);
        avlTree.root =  avlTree.insert(1);
        avlTree.print();

        avlTree.delete(13);
        avlTree.print();

    }
}
