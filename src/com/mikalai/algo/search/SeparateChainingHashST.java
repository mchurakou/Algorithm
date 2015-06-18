package com.mikalai.algo.search;

/**
 * Created by mikalai on 15.06.2015.
 */
public class SeparateChainingHashST<Key, Value> {

    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(int m) {
        M = m;

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < st.length; i++) {
            st[i] = new SequentialSearchST();

        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    private int hash(Key key) {
        return key.hashCode() & 0x7fffffff % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, String> map = new SeparateChainingHashST<String, String>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("2", "3");

        System.out.println(map.get("1"));
        System.out.println(map.get("2"));


    }
}
