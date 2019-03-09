package com.mikalai.algo.graph.shortpath;

import java.util.Stack;

/**
 * Created by mikalai on 05.10.2015.
 */
public abstract class ShortPath {
    protected final EdgeWeightedDigraph g;
    protected final int s;

    protected DirectedEdge[] edgeTo;
    protected double[] distTo;

    public ShortPath(EdgeWeightedDigraph g, int s) {
        this.g = g;
        this.s = s;

        edgeTo = new DirectedEdge[g.getE()];
        distTo = new double[g.getE()];
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<DirectedEdge> path = new Stack<>();

        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()]) {
            path.push(e);
        }

        return path;
    }
}
