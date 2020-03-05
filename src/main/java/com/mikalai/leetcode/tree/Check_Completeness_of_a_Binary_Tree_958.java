package com.mikalai.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Completeness_of_a_Binary_Tree_958 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Queue<TreeNode> queue = new LinkedList<>();

    public boolean isCompleteTree(TreeNode root) {
        queue.add(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null && node.right != null) {
                if (!foundNull) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    return false;
                }
            } else if (node.left != null) {
                if (!foundNull) {
                    queue.add(node.left);
                    foundNull = true;
                } else {
                    return false;
                }

            } else if (node.right != null) {
                return false;
            } else {
                foundNull = true;
            }
        }

        return true;

    }


}

