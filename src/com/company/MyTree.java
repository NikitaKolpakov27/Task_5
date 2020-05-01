package com.company;

import java.util.ArrayList;

class MyTree<T> {


    private class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        TreeNode(int value) {
            this(value, null, null);
        }
    }

    protected TreeNode root = null;


    private static ArrayList<Integer> list = new ArrayList<>();
    static int maxLeaf;
    void findMaxLeaf(TreeNode tree) {
        if (tree == null) {
            return;
        }

        if (tree.left == null && tree.right == null) {
            list.add(tree.value);
        }

        findMaxLeaf(tree.left);
        findMaxLeaf(tree.right);
        maxLeaf = list.get(list.size()-1);
    }

    private TreeNode addNode(TreeNode rootNode, int value) {
        if (rootNode == null) {
            return new TreeNode(value);
        } else {
            if (rootNode.value > value) {
                rootNode.left = addNode(rootNode.left, value);
            } else if (rootNode.value < value) {
                rootNode.right = addNode(rootNode.right, value);
            }
            return rootNode;
        }
    }

    void add(Integer value) {
        root = addNode(root, value);
    }

}
