package com.mikalai.algo.unionfind;

/**
 * Created by mikalai on 16.04.2015.
 */
public class WeightedUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedUnionUF(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p])
            p = id[p];

        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count--;
    }

    public static void main(String[] args) {
        int N = 7;

        WeightedUnionUF uf = new WeightedUnionUF(N);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(3, 4);
        uf.union(4, 5);

        System.out.println("Components:" + uf.count());
    }
}
