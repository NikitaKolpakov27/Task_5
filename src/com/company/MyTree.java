package com.company;

import java.util.ArrayList;
import java.util.Stack;

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

    int findMaxLeaf() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right == null && node.left == null) {
                list.add(node.value);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list.get(list.size() - 1);
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

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves (TreeNode tree) {
        if(tree == null)
            return 0;

        int max = 0;
        if (tree.left == null && tree.right == null) {
           return 1;
        } else {
            return countLeaves(tree.left) + countLeaves(tree.right);
        }
    }

}
