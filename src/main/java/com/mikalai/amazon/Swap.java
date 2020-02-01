package com.mikalai.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Swap {

    static class Node {
        private Node left;
        private Node right;
        private final int val;


        Node(final int val) {
            this.val = val;
        }
    }


    static int[][] swapNodes(int[][] indexes, int[] queries) {


        Node root = new Node(1);

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        int i = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (indexes[i][0] != -1) {
                Node left  = new Node(indexes[i][0]);
                node.left = left;
                queue.add(left);
            }

            if (indexes[i][1] != -1) {
                Node right  = new Node(indexes[i][1]);
                node.right = right;
                queue.add(right);
            }

            i++;
        }

        int[][] result = new int[queries.length][indexes.length];

        for (int j = 0; j < queries.length; j++) {
            int deep = queries[j];
            process(root, deep);
            result[j] = traverse(root);
        }



        return result;

    }

    private static void process(final Node root, final int deep) {
        sink(root, deep, 1);
    }

    private static void sink(final Node root, final int deep, final int level) {
        if (level % deep == 0) {
            swap(root);
        }

        if (root.left != null) {
            sink(root.left, deep, level + 1);
        }

        if (root.right != null) {
            sink(root.right, deep, level + 1);
        }
    }

    private static void swap(final Node root) {
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    private static int[] traverse(final Node root) {
        List<Integer> list =  new ArrayList<>();
        traverse(root, list);

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    private static void traverse(final Node root, final List<Integer> list) {
        if (root.left != null) {
            traverse(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            traverse(root.right, list);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(swapNodes(new int[][]{{2,3},{-1, -1}, {-1, -1}}, new int[]{1, 1})));
        System.out.println(Arrays.deepToString(swapNodes(new int[][]{{2,3},{-1, 4}, {-1, 5}, {-1, -1} , {-1, -1}}, new int[]{2})));
        System.out.println(Arrays.deepToString(swapNodes(new int[][]{{2,3},{4, -1}, {5, -1}, {6, -1} , {7, 8}, {-1, 9}, {-1, -1}, {10, 11}, {-1, -1}, {-1, -1}, {-1, -1}}, new int[]{2, 4})));
    }


}
