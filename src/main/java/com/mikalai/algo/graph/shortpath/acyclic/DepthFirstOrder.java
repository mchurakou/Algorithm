package com.mikalai.algo.graph.shortpath.acyclic;

import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mikalai on 23.08.2015.
 */
public class DepthFirstOrder {
    private boolean[] marked;

    public Deque<Integer> getReversePost() {
        return reversePost;
    }

    private Deque<Integer> reversePost;

    public DepthFirstOrder(EdgeWeightedDigraph g) {
        reversePost = new LinkedList<>();
        marked = new boolean[g.getV()];
        for (int v = 0; v < g.getV(); v++)
            if (!marked(v)) dfs(g, v);
    }

    private void dfs(EdgeWeightedDigraph g, int v) {

        marked[v] = true;

        for (DirectedEdge w : g.adj(v)) {
            if (!marked[w.getTo()]) {
                dfs(g, w.getTo());
            }

        }
        reversePost.addFirst(v);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
