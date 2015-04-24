package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 24.04.2015.
 */
public abstract class Sort {
    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
