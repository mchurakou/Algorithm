package com.mikalai.algo.graph.directed;

/**
 * Created by mikalai on 17.08.2015.
 */
public class DirectedDepthFirstSearch {

    private boolean[] marked;

    public DirectedDepthFirstSearch(Digraph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }

        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }


    public static void main(String[] args) {
        Digraph g = new Digraph(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        DirectedDepthFirstSearch dps = new DirectedDepthFirstSearch(g, 0);

        System.out.println(dps.hasPathTo(5));

    }

}
