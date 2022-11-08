package com.example.telecom.paris.maze.graph.impl;

import com.example.telecom.paris.maze.graph.Distance;
import com.example.telecom.paris.maze.graph.Graph;
import com.example.telecom.paris.maze.graph.Vertex;

import java.util.HashSet;
import java.util.Set;

public class BasicGraph implements Graph, Distance {

    private final Set<Vertex> vertexes;

    private final Set<BasicEdge> edges;

    public BasicGraph() {
        vertexes = new HashSet<>();
        edges = new HashSet<>();
    }

    @Override
    public Set<Vertex> getVertexes() {
        return vertexes;
    }

    @Override
    public int getDistance(Vertex vertex1,
                           Vertex vertex2) {
        for (BasicEdge edge : edges) {
            if ((vertex1.equals(edge.getVertex1()) && vertex2.equals(edge.getVertex2())) ||
                    (vertex2.equals(edge.getVertex1()) && vertex1.equals(edge.getVertex2()))) {
                return edge.getDistance();
            }
        }

        return -1;
    }

    @Override
    public Vertex getVertex(String name) {
        for (final Vertex vertex : getVertexes()) {
            if (name.equals(vertex.getLabel())) {
                return vertex;
            }
        }

        return null;
    }

    @Override
    public Set<Vertex> getSuccessors(Vertex vertex) {
        final Set<Vertex> successors = new HashSet<>();

        for (final BasicEdge edge : edges) {
            if (vertex.equals(edge.getVertex1())) {
                successors.add(edge.getVertex2());
            }

            if (vertex.equals(edge.getVertex2())) {
                successors.add(edge.getVertex1());
            }
        }

        return successors;
    }

    public void addEdge(Vertex vertex1,
                        Vertex vertex2,
                        int distance) {
        edges.add(new BasicEdge(vertex1, vertex2, distance));
    }
}
