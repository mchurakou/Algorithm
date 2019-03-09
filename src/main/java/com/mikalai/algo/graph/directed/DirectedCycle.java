package com.mikalai.algo.graph.directed;

import java.util.Stack;

/**
 * Created by mikalai on 23.08.2015.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g) {
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];


        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);

            }

        }
    }

    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);

                }
                cycle.push(w);
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

    public static void main(String[] args) {
        Digraph g = new Digraph(4);

//        g.addEdge(2, 3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 0);

        DirectedCycle c = new DirectedCycle(g);
        System.out.println("cycle:" + c.hasCycle());
        if (c.hasCycle()) {
            for (Integer n : c.cycle) {
                System.out.println(n);
            }
        }
    }
}
