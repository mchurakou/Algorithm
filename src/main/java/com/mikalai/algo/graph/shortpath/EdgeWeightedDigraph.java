package com.mikalai.algo.graph.shortpath;

import com.mikalai.algo.graph.weighted.Edge;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mikalai on 05.10.2015.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Set<DirectedEdge>[] adj;

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Set<DirectedEdge>[]) new Set[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedHashSet<DirectedEdge>();

        }
    }

    public void addEdge(DirectedEdge e) {
        adj[e.getFrom()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Set<DirectedEdge> b = new LinkedHashSet<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                b.add(e);

            }
        }

        return b;
    }
}
