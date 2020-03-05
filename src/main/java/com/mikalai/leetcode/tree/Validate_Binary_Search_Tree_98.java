package com.mikalai.leetcode.tree;

public class Validate_Binary_Search_Tree_98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        return check(root, Integer.MIN_VALUE, false, Integer.MAX_VALUE, false);

    }

    private boolean check(final TreeNode node, int minValue, boolean includeMinValue, int maxValue, boolean includeMaxValue) {
        if (node == null) {
            return true;
        }

        if ((node.val > maxValue || node.val == maxValue && includeMaxValue)  || (node.val < minValue || node.val == minValue && includeMinValue) ) {
            return false;
        }

        return (node.left == null || check(node.left, minValue, includeMinValue, node.val, true)) &&
            (node.right == null || check(node.right, node.val,true,  maxValue, includeMaxValue));
    }



    public static void main(String[] args) {
        Validate_Binary_Search_Tree_98 v = new Validate_Binary_Search_Tree_98();
        System.out.println(v.isValidBST(new TreeNode(2147483647)));

    }
}
