package graph.impl;

import graph.ShortestPaths;
import graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicShortestPaths implements ShortestPaths {

    private final Map<Vertex, Vertex> previousEdges;

    public BasicShortestPaths() {
        previousEdges = new HashMap<>();
    }

    @Override
    public void setPrevious(Vertex vertexEnd, Vertex vertexPrevious) {
        previousEdges.put(vertexEnd, vertexPrevious);
    }

    @Override
    public List<Vertex> getShortestPath(Vertex startVertex,
                                        Vertex endVertex) {
        final List<Vertex> shortestPath = new ArrayList<>();
        Vertex previous = endVertex;

        do {
            shortestPath.add(0, previous);
            previous = previousEdges.get(previous);
        } while (previous != null && !startVertex.equals(previous));

        shortestPath.add(0, previous);

        return shortestPath;
    }
}
