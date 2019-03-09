package com.mikalai.algo.string.sort.msd;


/**
 * Created by mikalai on 02.02.2016.
 */
public class MostSignificantDigit {
    private static int ALPHABET_SIZE = 256;
    private static final int SORT_THRESHOLD = 15;
    private static String[] aux;

    private static int charAt(String s, int digitPosition) {
        if (digitPosition < s.length())
            return s.charAt(digitPosition);
        else
            return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int digitPosition) {
        if (hi <= lo + SORT_THRESHOLD) {
            Insertion.sort(a, lo, hi, digitPosition);
            return;
        }

        int[] count = new int[ALPHABET_SIZE + 2];

        for (int i = lo; i < hi; i++) { //вычисление счетчиков повторений
            count[charAt(a[i], digitPosition) + 2]++;
        }

        for (int r = 0; r < ALPHABET_SIZE + 1; r++) { //преобразование счетчиков в индексы
            count[r + 1] += count[r];
        }

        for (int i = lo; i <= hi; i++) { //распределение
            aux[count[charAt(a[i], digitPosition) + 1]++] = a[i];
        }

        for (int i = lo; i < hi; i++) { // копирование назад
            a[i] = aux[i - lo];
        }

        //рекурсивная сортировка для каждого значения символа
        for (int r = 0; r < ALPHABET_SIZE; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, digitPosition + 1);
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
