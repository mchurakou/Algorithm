package com.mikalai.algo.string.trie;

import java.util.LinkedList;
import java.util.Queue;

public class TrieSearchTable<Value> {
    private static int ALPHABET_SIZE = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[ALPHABET_SIZE];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        } else {
            return (Value) x.val;
        }

    }

    private Node get(Node x, String key, int charPosition) {
        if (x == null) {
            return null;
        }

        if (charPosition == key.length()) {
            return x;
        }

        char c = key.charAt(charPosition);

        return get(x.next[c], key, charPosition + 1);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int charPosition) {
        if (x == null) {
            x = new Node();
        }

        if (charPosition == key.length()) {
            x.val = value;
            return x;
        }

        char c = key.charAt(charPosition);

        x.next[c] = put(x.next[c], key, value, charPosition + 1);

        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) cnt++;

        for (char c = 0; c < ALPHABET_SIZE; c++) {
            cnt += size(x.next[c]);
        }

        return cnt;
    }

    public Iterable<String> keys(){
        return keysWithPrefix("");
    }

    private Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node node, String pre, Queue<String> q) {
        if (node == null) return;

        if (node.val != null) q.add(pre);

        for (char c = 0; c < ALPHABET_SIZE; c++) {
            collect(node.next[c], pre + c, q);

        }
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pattern, q);
        return q;
    }

    private void collect(Node x, String pre, String pattern, Queue<String> q) {
        int d = pre.length();

        if (x == null) return;

        if (d == pattern.length() && x.val != null) {
            q.add(pre);
        }

        if (d == pattern.length()) {
            return;
        }

        char next = pattern.charAt(d);

        for (char c = 0; c < ALPHABET_SIZE; c++) {
            if (next == '.' || c == next){
                collect(x.next[c], pre + c, pattern, q);
            }
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;

        if (x.val != null) length = d;
        if (d == s.length()) return length;

        char c = s.charAt(d);

        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) {
            return x;
        }

        for (char c = 0; c < ALPHABET_SIZE; c++) {
            if (x.next[c] != null){
                return x;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        TrieSearchTable<String> trie = new TrieSearchTable<>();
        trie.put("s", "s");
        trie.put("sa", "sa");
        trie.put("sas", "sas");
        trie.put("sat", "sat");

        System.out.println(trie.size());

        System.out.println(trie.keysWithPrefix("s"));

        System.out.println(trie.keysThatMatch("s."));

        System.out.println(trie.longestPrefixOf("sax"));


        System.out.println("DELETED");
        trie.delete("sas");

        System.out.println(trie.keysWithPrefix("s"));


    }
}
