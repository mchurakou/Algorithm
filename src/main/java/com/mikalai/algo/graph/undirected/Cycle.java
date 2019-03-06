package com.mikalai.algo.graph.undirected;

/**
 * Created by mikalai on 13.07.2015.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g) {
        marked = new boolean[g.getVertexCount()];

        for (int s = 0; s < g.getVertexCount(); s++) {
            if (!marked[s]) {
                dfs(g, s, s);

            }

        }
    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        for (int w : g.adjacentVertexes(v)) {
            if (!marked[w]) {

                dfs(g, w, v);
            } else if (w != u) {
                hasCycle = true;
            }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

//        g.addEdge(2, 3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        Cycle c = new Cycle(g);
        System.out.println("cycle:" + c.hasCycle);
    }
}
