package com.mikalai.algo.unionfind;

/**
 * Created by mikalai on 16.04.2015.
 */
public class WeightedUnionUF {
    private int[] parentIds;
    private int[] componentSize;
    private int count;

    public WeightedUnionUF(int count) {
        this.count = count;
        parentIds = new int[count];
        componentSize = new int[count];
        for (int i = 0; i < count; i++) {
            parentIds[i] = i;
            componentSize[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        while (p != parentIds[p])
            p = parentIds[p];

        return p;
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        if (componentSize[pRoot] < componentSize[qRoot]) {
            parentIds[pRoot] = qRoot;
            componentSize[qRoot] += componentSize[pRoot];
        } else {
            parentIds[qRoot] = pRoot;
            componentSize[pRoot] += componentSize[qRoot];
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
