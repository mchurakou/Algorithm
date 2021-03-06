package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 24.04.2015.
 */
public class Selection extends Sort {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;

            exch(a, i, min);

        }
    }
}
