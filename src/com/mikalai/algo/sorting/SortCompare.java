package com.mikalai.algo.sorting;

import java.util.Arrays;

/**
 * Created by mikalai on 17.05.2015.
 */
public class SortCompare {


    private static double time(Sort sort, Integer[] a) {
        long start = System.currentTimeMillis();
        sort.sort(a);
        long end = System.currentTimeMillis();

        return end - start;
    }

    public static void main(String[] args) {
        int n = 1000;
        int t = 100;

//        Double[] a = new Double[n];

        Integer[] a = new Integer[n];


        Sort selection = new Selection();
        Sort insertion = new Insertion();
        Sort bubble = new Bubble();
        Sort shell = new Shell();
        Sort merge = new Merge();
        Sort mergeBU = new MergeBU();


        double selectionResult = 0;
        double insertionResult = 0;
        double bubbleResult = 0;
        double shellResult = 0;
        double mergeResult = 0;
        double mergeBUResult = 0;

        for (int j = 0; j < t; j++) {
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * 100);
            }

            bubbleResult += time(bubble, Arrays.copyOf(a, a.length));
            selectionResult += time(selection, Arrays.copyOf(a, a.length));
            insertionResult += time(insertion, Arrays.copyOf(a, a.length));
            shellResult += time(shell, Arrays.copyOf(a, a.length));
            mergeResult += time(merge, Arrays.copyOf(a, a.length));
            mergeBUResult += time(mergeBU, Arrays.copyOf(a, a.length));


        }

        System.out.println("bubbleResult: " + bubbleResult);
        System.out.println("selectionResult: " + selectionResult);
        System.out.println("insertionResult: " + insertionResult);
        System.out.println("shellResult: " + shellResult);
        System.out.println("mergeResult: " + mergeResult);
        System.out.println("mergeBUResult: " + mergeBUResult);


    }
}
