package com.mikalai.algo.sorting;

import java.util.Arrays;

/**
 * Created by mikalai on 18.05.2015.
 */
public class MergeAscendingRecursive extends Sort {
    protected static Comparable[] aux;


    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }


        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }

        }



    }
}
