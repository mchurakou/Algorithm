package com.mikalai.algo.search.tree;

/**
 * Created by mikalai on 31.05.2015.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {

        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);

    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;

        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t!= null) return t;
        else
            return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;

        int t = size(x.left);

        if (t >  k)
            return select(x.left, k);
        else if (t < k){
            return select(x.right, k - t - 1);
        } else {
            return x;
        }

    }

    public int rank(Key key){
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;

        int cmp = key.compareTo(x.key);

        if (cmp < 0){
            return rank(key, x.left);
        } else if (cmp > 0){
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin(){

        root  = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null) return x.right;

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if (x == null) return null;

        int cmp  = key.compareTo(x.key);

        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0 ) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;

            if (x.left == null) return x.right;

            Node t = x;

            x = min(t.right);

            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right)  + 1;
        return x;

    }

    public void print(){
        print(root);
    }

    private void print(Node x){
        if (x == null) return;

        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }

    public static void main(String[] args) {
        BinarySearchTree map = new BinarySearchTree<String, String>();
        map.put("1", "s11");
        map.put("2", "s22");
        map.put("3", "s33");

        System.out.println("pr");
        map.print();
        System.out.println("pr");

        System.out.println(map.get("1"));
        System.out.println(map.get("2"));

        System.out.println(map.min());
        System.out.println(map.floor("23"));

        System.out.println(map.select(1));

        System.out.println(map.rank("0"));

        map.deleteMin();



        map.delete("3");
        System.out.println(map.min());
    }


}

