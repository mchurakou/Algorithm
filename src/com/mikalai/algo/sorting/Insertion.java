package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 24.04.2015.
 */
public class Insertion extends Sort {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);

        }
    }
}