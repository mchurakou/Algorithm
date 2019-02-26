package com.mikalai.algo.search;

/**
 * Created by Mikalai_Churakou on 6/18/2015.
 */
public class LinearProbingHashST<Key, Value> {
    private int N;

    private int M = 16;

    private Key[] keys;

    private Value[] vals;

    public LinearProbingHashST(){
        keys = (Key[]) new Object[M];
        vals = (Value[])new Object[M];
    }

    private int hash(Key key) {
        return key.hashCode() & 0x7fffffff % M;
    }

    private void resize(int x){

    }

    public void put(Key key, Value val){
        if (N > M/2){
            resize(2 * M);
        }
        int i;

        for (i = hash(key); keys[i] != null; i = (i + 1) / M) {
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i + 1) / M) {
            if (keys[i].equals(key)){
                return vals[i];
            }


       }
        return null;
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, String> map = new LinearProbingHashST<String, String>();

        map.put("1","s1");
        map.put("2","s2");
        map.put("1","s11");

        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
    }

}
