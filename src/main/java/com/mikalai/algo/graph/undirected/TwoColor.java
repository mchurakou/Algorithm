package com.mikalai.algo.graph.undirected;

/**
 * Created by mikalai on 13.07.2015.
 */
public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    public boolean isTwoColorable = true;

    public TwoColor(Graph g) {
        marked = new boolean[g.getVertexCount()];
        color = new boolean[g.getVertexCount()];

        for (int s = 0; s < g.getVertexCount(); s++) {
            if (!marked[s]) {
                dfs(g, s);

            }

        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adjacentVertexes(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
//        g.addEdge(0, 2);
        g.addEdge(2, 3);

        TwoColor tc = new TwoColor(g);
        System.out.println("two color:" + tc.isTwoColorable);
    }
}
