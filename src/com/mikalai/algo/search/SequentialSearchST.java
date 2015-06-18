package com.mikalai.algo.search;

/**
 * Created by mikalai on 30.05.2015.
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key k, Value v, Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
    }

    public Value get(Key k) {
        for (Node x = first; x != null; x = first.next) {
            if (k.equals(x.key)) {
                return x.val;
            }
        }

        return null;
    }

    public void put(Key k, Value v) {
        for (Node x = first; x != null; x = first.next) {
            if (k.equals(x.key)) {
                x.val = v;
                return;
            }
        }

        first = new Node(k, v, first);
    }

    public static void main(String[] args) {
        SequentialSearchST map = new SequentialSearchST<String, String>();
        map.put("s1", "s11");
        map.put("s2", "s22");
        map.put("s2", "s33");

        System.out.println(map.get("s1"));
        System.out.println(map.get("s2"));
    }
}
