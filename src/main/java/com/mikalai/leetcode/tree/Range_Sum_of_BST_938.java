package com.mikalai.leetcode.tree;

public class Range_Sum_of_BST_938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        } else {
            int result = 0;

            if (root.val >= L && root.val <= R) {
                result += root.val;
            }

            if (root.val >= L) {
                result += rangeSumBST(root.left, L, R);
            }

            if (root.val <= R) {
                result += rangeSumBST(root.right, L, R);
            }


            return result;
        }

    }
}
