package com.example.telecom.paris.maze.graph.impl;

import com.example.telecom.paris.maze.graph.Graph;
import com.example.telecom.paris.maze.graph.Vertex;

import java.util.Set;

public class BasicVertex implements Vertex {

    private final String name;

    private final Graph graph;

    public BasicVertex(final String name,
                       final Graph graph) {
        this.name = name;
        this.graph = graph;
    }

    @Override
    public Set<Vertex> getSuccessors() {
        return graph.getSuccessors(this);
    }

    @Override
    public String getLabel() {
        return name;
    }
}
