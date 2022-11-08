package com.example.telecom.paris.maze.graph;

public interface ProcessedVertexesSet {

    void add(Vertex vertex);

    boolean contains(Vertex vertex);
}
