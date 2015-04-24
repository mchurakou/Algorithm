package com.mikalai.algo.sorting;

/**
 * Created by mikalai on 24.04.2015.
 */
public class Example {


    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (Sort.less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{5, 2, 5, 1, 66, 10, 11, 22};
//        Selection.sort(a);
        Insertion.sort(a);
        assert isSorted(a);
        show(a);
    }


}
