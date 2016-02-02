package com.mikalai.algo.string.sort.msd;

/**
 * Created by mikalai on 02.02.2016.
 */
public class Insertion {
    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(String[] a, int j, int i) {
        String tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }


}
