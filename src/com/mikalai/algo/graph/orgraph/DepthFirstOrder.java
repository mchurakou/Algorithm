package com.mikalai.algo.graph.orgraph;

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

    public DepthFirstOrder(Digraph g) {
        reversePost = new Stack<Integer>();
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
        reversePost.push(v);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
