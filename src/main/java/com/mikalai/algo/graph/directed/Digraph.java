package com.mikalai.algo.graph.directed;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 17.08.2015.
 */
public class Digraph {
    private final int V;
    private int E;
    private Set<Integer>[] adj;

    public Digraph(int v) {
        V = v;
        this.E = 0;

        adj = (Set<Integer>[]) new Set[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedHashSet<Integer>();

        }

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);

        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }

        }

        return R;
    }
}
