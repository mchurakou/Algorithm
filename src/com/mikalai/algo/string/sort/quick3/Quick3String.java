package com.mikalai.algo.string.sort.quick3;

/**
 * Created by mikalai on 02.02.2016.
 */
public class Quick3String {
    private static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);

        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;

        }

        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);

    }

    private static void exch(String[] a, int j, int i) {
        String tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public static void main(String[] args) {
        String[] ar = {"12345", "2334522", "98387", "5566722", "23232323", "4444", "44222"};

        sort(ar);


        for (String s : ar) {
            System.out.println(s);
        }
    }
}
