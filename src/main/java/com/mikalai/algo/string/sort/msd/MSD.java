package com.mikalai.algo.string.sort.msd;


/**
 * Created by mikalai on 02.02.2016.
 */
public class MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];

        for (int i = lo; i < hi; i++) { //вычисление счетчиков повторений
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) { //преобразование счетчиков в индексы
            count[r + 1] += count[r];
        }

        for (int i = lo; i <= hi; i++) { //распределение
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i < hi; i++) { // копирование назад
            a[i] = aux[i - lo];
        }

        //рекурсивная сортировка для каждого значения символа
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] ar = {"12345", "2334522", "98387", "5566722", "23232323", "4444", "44222"};

        sort(ar);


        for (String s : ar) {
            System.out.println(s);
        }
    }
}
