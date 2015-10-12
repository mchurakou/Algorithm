package com.mikalai.algo.graph.shortpath.acyclic;

import com.mikalai.algo.graph.orgraph.Digraph;
import com.mikalai.algo.graph.shortpath.DirectedEdge;
import com.mikalai.algo.graph.shortpath.EdgeWeightedDigraph;

import java.util.Stack;

/**
 * Created by mikalai on 23.08.2015.
 */
public class DepthFirstOrder {
    private boolean[] marked;

    public Stack<Integer> getReversePost() {
        return reversePost;
    }

    private Stack<Integer> reversePost;

    public DepthFirstOrder(EdgeWeightedDigraph g) {
        reversePost = new Stack<Integer>();
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
        reversePost.push(v);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
