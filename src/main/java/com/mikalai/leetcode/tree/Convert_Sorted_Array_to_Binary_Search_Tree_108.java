package com.mikalai.leetcode.tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }

        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(final int[] nums, final int from, final int to) {
        int middle = (from + to) / 2;

        TreeNode node = new TreeNode(nums[middle]);

        if (middle > from) {
            node.left = makeTree(nums, from, middle - 1);
        }

        if (middle < to) {
            node.right = makeTree(nums, middle + 1, to);
        }


        return node;
    }

    public static void main(String[] args) {
        Convert_Sorted_Array_to_Binary_Search_Tree_108 c = new Convert_Sorted_Array_to_Binary_Search_Tree_108();
        TreeNode treeNode = c.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        treeNode = c.sortedArrayToBST(new int[]{-10});
        treeNode = c.sortedArrayToBST(new int[]{});
    }


}
