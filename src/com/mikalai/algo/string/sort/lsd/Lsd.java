package com.mikalai.algo.string.sort.lsd;

/**
 * Created by mikalai on 26.01.2016.
 */
public class Lsd {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];


        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1]; // Вычисляем счетчник повторений

            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) { // Преобразование счетчиков в индексы
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) { // Распределение
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i = 0; i < N; i++) { // Копирование назад
                a[i] = aux[i];
            }
        }

    }

    public static void main(String[] args) {
        String[] ar = {"12345", "23345", "98387", "55667"};

        sort(ar, 4);


        for (String s : ar) {
            System.out.println(s);
        }

    }
}
