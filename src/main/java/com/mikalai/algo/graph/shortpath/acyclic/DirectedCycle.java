package com.mikalai.algo.graph.shortpath.acyclic;

import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;

import java.util.Stack;

/**
 * Created by mikalai on 23.08.2015.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(EdgeWeightedDigraph g) {
        onStack = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        marked = new boolean[g.getV()];


        for (int s = 0; s < g.getV(); s++) {
            if (!marked[s]) {
                dfs(g, s);

            }

        }
    }

    private void dfs(EdgeWeightedDigraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge w : g.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w.getTo()]) {
                edgeTo[w.getTo()] = v;
                dfs(g, w.getTo());
            } else if (onStack[w.getTo()]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w.getTo(); x = edgeTo[x]) {
                    cycle.push(x);

                }
                cycle.push(w.getTo());
                cycle.push(v);
            }

        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Stack<Integer> cycle() {
        return cycle;
    }

}
