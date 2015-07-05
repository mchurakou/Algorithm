package com.mikalai.algo.graph;

import java.util.Stack;

/**
 * Created by mikalai on 05.07.2015.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int count;
    private final int s;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
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

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);

        DepthFirstSearch dps = new DepthFirstSearch(g, 0);

        System.out.println(dps.count());
        System.out.println(dps.hasPathTo(3));

        System.out.println(dps.pathTo(3));
    }

}
