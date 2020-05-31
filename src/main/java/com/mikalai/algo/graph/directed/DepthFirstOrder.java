package com.mikalai.algo.graph.directed;

import com.mikalai.algo.graph.directed.Digraph;

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

    public DepthFirstOrder(Digraph g) {
        reversePost = new LinkedList<>();
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++)
            if (!marked(v)) dfs(g, v);
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
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
