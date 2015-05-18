package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 18.05.2015.
 */
public class MergeBU extends Merge {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz + 1, N - 1));
            }

        }
    }
}
