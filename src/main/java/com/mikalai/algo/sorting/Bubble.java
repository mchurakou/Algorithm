package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 17.05.2015.
 */
public class Bubble extends Sort {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j - 1, j);
                }
            }


        }
    }
}
