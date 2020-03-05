package com.mikalai.leetcode.tree;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;

            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);

        if (prevSlow != null) {
            prevSlow.next = null;
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(slow.next);
        }

        return node;

    }





    public static void main(String[] args) {
        Convert_Sorted_List_to_Binary_Search_Tree_109 c = new Convert_Sorted_List_to_Binary_Search_Tree_109();
        ListNode a1 = new ListNode(-10);
        ListNode a2 = new ListNode(-3);
        a1.next = a2;
        ListNode a3 = new ListNode(0);
        a2.next = a3;
        ListNode a4 = new ListNode(5);
        a3.next = a4;
        ListNode a5 = new ListNode(9);
        a4.next = a5;

        TreeNode treeNode = c.sortedListToBST(a1);

    }


}
