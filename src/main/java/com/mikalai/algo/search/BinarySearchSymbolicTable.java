package com.mikalai.algo.search;

/**
 * Created by mikalai on 30.05.2015.
 */
public class BinarySearchSymbolicTable<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchSymbolicTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];


    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (size() == 0) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;

    }

    public void put(Key key, Value val) {
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];

        }

        keys[i] = key;
        vals[i] = val;

        N++;


    }

    private int rank(Key key) {
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }

        }

        return lo;

    }

    public static void main(String[] args) {
        BinarySearchSymbolicTable map = new BinarySearchSymbolicTable<String, String>(20);
        map.put("s1", "s11");
        map.put("s2", "s22");
        map.put("s2", "s33");

        System.out.println(map.get("s1"));
        System.out.println(map.get("s2"));
    }
}
