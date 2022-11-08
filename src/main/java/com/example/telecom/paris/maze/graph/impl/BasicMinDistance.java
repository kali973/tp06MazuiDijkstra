package com.example.telecom.paris.maze.graph.impl;

import com.example.telecom.paris.maze.graph.MinDistance;
import com.example.telecom.paris.maze.graph.ProcessedVertexesSet;
import com.example.telecom.paris.maze.graph.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicMinDistance implements MinDistance {

    private final Map<Vertex, Integer> minDistances;

    public BasicMinDistance() {
        minDistances = new HashMap<>();
    }

    @Override
    public void setMinDistance(Vertex vertex,
                               int distance) {
        minDistances.put(vertex, distance);
    }

    @Override
    public int getMinDistance(Vertex vertex) {
        return minDistances.get(vertex);
    }

    @Override
    public Vertex getMinDistanceVertex(ProcessedVertexesSet processedVertexes,
                                       Set<Vertex> vertexes) {
        int minDistance = Integer.MAX_VALUE;
        Vertex minDistVertex = null;

        for (final Vertex vertex : vertexes) {
            if (!processedVertexes.contains(vertex)) {
                final int minDistanceVirtex = getMinDistance(vertex);

                if (minDistanceVirtex < minDistance) {
                    minDistance = minDistanceVirtex;
                    minDistVertex = vertex;
                }
            }
        }

        return minDistVertex;
    }
}
