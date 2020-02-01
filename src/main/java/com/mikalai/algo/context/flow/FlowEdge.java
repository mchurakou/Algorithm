package com.mikalai.algo.context.flow;

public class FlowEdge {
    private final int from;
    private final int to;
    private final double capacity;
    private double flow;

    public FlowEdge(final int from, final int to, final double capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFlow() {
        return flow;
    }

    public int other(int vertex) {
        if (vertex == from) return to;
        else if (vertex == to) return from;
        else throw new RuntimeException("Wrong edge");

    }

    public double residualCapacityTo(int vertex) {
        if (vertex == from)
            return flow;
        else if (vertex == to)
            return capacity - flow;
        else throw new RuntimeException("Wrong edge");
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == from)
            flow =- delta;
        else if (vertex == to)
            flow += delta;
        else throw new RuntimeException("Wrong edge");
    }

    @Override
    public String toString() {
        return "FlowEdge{" +
            "from=" + from +
            ", to=" + to +
            ", capacity=" + capacity +
            ", flow=" + flow +
            '}';
    }
}
