package com.mikalai.algo.graph;

import com.mikalai.algo.collections.queue.LinkedListQueue;

import java.util.Stack;

/**
 * Created by mikalai on 12.07.2015.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();

        marked[s] = true;

        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }

            }
        }


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

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.addEdge(4, 5);
        g.addEdge(2, 5);

        BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);


        System.out.println(bfp.hasPathTo(5));

        System.out.println(bfp.pathTo(5));
    }

}
