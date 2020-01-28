package com.mikalai.greedy;

public class GreedyBagRecursion {
    public static void main(String[] args) {
        int n = 4;
        int maxCapacity = 14;
        int[] value = {3, 5, 4, 2};
        int[] weight = {5, 10, 6, 5};


        System.out.println(greedy(0, 0, 0, maxCapacity, n, value, weight));

    }

    private static int greedy(final int currentValue, final int currentCapacity, final int indexOfItem, final int maxCapacity, final int n, final int[] value, final int[] weight) {
        if (n > indexOfItem) {
            if (maxCapacity >= currentCapacity + weight[indexOfItem]) {
                return Math.max(greedy(currentValue + value[indexOfItem], currentCapacity + weight[indexOfItem], indexOfItem + 1, maxCapacity, n, value, weight),
                    greedy(currentValue, currentCapacity, indexOfItem + 1, maxCapacity, n, value, weight));
            } else {
                return greedy(currentValue, currentCapacity, indexOfItem + 1, maxCapacity, n, value, weight);
            }

        } else {
            return currentValue;
        }

    }
}
