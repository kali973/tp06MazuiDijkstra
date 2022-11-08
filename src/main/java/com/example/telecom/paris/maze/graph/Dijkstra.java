package com.example.telecom.paris.maze.graph;

import com.example.telecom.paris.maze.graph.impl.*;

import java.util.Iterator;

public class Dijkstra {

    public static void main(String[] args) {


        final BasicGraph testGraph = new BasicGraph();

        final int nbNodes = 10;

        for (int index = 0; index < nbNodes; index++) {
            testGraph.getVertexes().add(new BasicVertex(Integer.toString(index), testGraph));
        }

        final Iterator<Vertex> vertexes = testGraph.getVertexes().iterator();
        final Vertex startVertex = vertexes.next();
        final Vertex endVertex = testGraph.getVertex(Integer.toString(nbNodes - 2));
        Vertex pivotVertex = startVertex;

        while (vertexes.hasNext()) {
            testGraph.addEdge(pivotVertex, vertexes.next(), 1);
        }

        final ShortestPaths paths = findShortestPaths(testGraph,
                startVertex,
                endVertex,
                new BasicVertexesSet(),
                new BasicMinDistance(),
                testGraph);

        for (final Vertex vertex : paths.getShortestPath(startVertex, endVertex)) {
            System.out.print(vertex.getLabel() + " -> ");
        }
    }

    public static ShortestPaths findShortestPaths(Graph graph,
                                                  Vertex startVertex,
                                                  Vertex endVertex,
                                                  ProcessedVertexesSet processedVertexes,
                                                  MinDistance minDistance,
                                                  Distance distance) {
        final ShortestPaths shortestPaths = new BasicShortestPaths();
        processedVertexes.add(startVertex);
        Vertex pivotVertex = startVertex;
        minDistance.setMinDistance(startVertex, 0);

        for (Vertex vertex : graph.getVertexes()) {
            if (!startVertex.equals(vertex) && pivotVertex != null) {
                minDistance.setMinDistance(vertex, Integer.MAX_VALUE);
            }
        }

        while (!processedVertexes.contains(endVertex) && pivotVertex != null) {
            for (Vertex succVertex : pivotVertex.getSuccessors())
                if (!processedVertexes.contains(succVertex)) {
                    int currentDistance = minDistance.getMinDistance(pivotVertex) + distance.getDistance(pivotVertex, succVertex);

                    if (currentDistance < minDistance.getMinDistance(succVertex)) {
                        minDistance.setMinDistance(succVertex, currentDistance);
                    }

                    shortestPaths.setPrevious(succVertex, pivotVertex);
                }

            pivotVertex = minDistance.getMinDistanceVertex(processedVertexes, graph.getVertexes());
            processedVertexes.add(pivotVertex);
        }
        return shortestPaths;
    }
}
