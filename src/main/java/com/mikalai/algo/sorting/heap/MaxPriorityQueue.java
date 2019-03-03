package com.mikalai.algo.sorting.heap;

import com.mikalai.algo.sorting.Sort;

/**
 * Created by mikalai on 20.05.2015.
 * k=0 - not used
 * parent of k - k/2
 * children of k - 2k and 2k + 1
 *
 */
public class MaxPriorityQueue<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MaxPriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    private void swim(int k) {

        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) break;

            exch(k, j);

            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);

        pq.insert(4);
        pq.insert(4);
        pq.insert(14);
        pq.insert(-4);
        pq.insert(24);

        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
