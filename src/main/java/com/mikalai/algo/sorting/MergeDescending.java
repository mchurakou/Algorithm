package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 18.05.2015.
 */
public class MergeDescending extends MergeAscendingRecursive {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int size = 1; size < N; size += size) {
            for (int lo = 0; lo < N - size; lo += size + size) {
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }

        }
    }
}
