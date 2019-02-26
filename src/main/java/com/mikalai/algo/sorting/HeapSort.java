package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 22.05.2015.
 */
public class HeapSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(a, j, j + 1)) {
                j++;
            }

            if (!less(a, k, j)) break;

            exch(a, k, j);

            k = j;
        }

    }

    private boolean less(Comparable[] a, int k, int j) {
        return a[k - 1].compareTo(a[j - 1]) < 0;
    }


    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }


}
