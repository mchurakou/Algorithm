package com.mikalai.greedy;

import java.util.Arrays;

public class GreedyBag {
    public static void main(String[] args) {
        int n = 4;
        int maxCapacity = 14;
        int[] value = {3, 5, 4, 2};
        int[] weight = {5, 10, 6, 5};

        int[][] bag = new int[n + 1][maxCapacity + 1];

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= maxCapacity; i++){
                if (i < weight[j - 1]) {
                    bag[j][i] = bag[j - 1][i];
                } else {
                    bag[j][i] = Math.max(bag[j - 1][i], value[j - 1] + bag[j - 1][i - weight[j - 1]]);
                }
            }
        }


        System.out.println(Arrays.deepToString(bag));
        System.out.println(bag[n][maxCapacity]);
    }
}
