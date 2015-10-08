package com.mikalai.algo.graph.shortpath;

/**
 * Created by mikalai on 05.10.2015.
 */
public class DirectedEdge {
    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}
