package graph.impl;

import graph.Vertex;

public class BasicEdge {

    private final Vertex vertex1;

    private final Vertex vertex2;

    private final int distance;

    public BasicEdge(final Vertex vertex1,
                     final Vertex vertex2,
                     final int distance) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;

        this.distance = distance;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public int getDistance() {
        return distance;
    }
}
