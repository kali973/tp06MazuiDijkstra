package graph;

import java.util.List;

public interface ShortestPaths {

    void setPrevious(Vertex vertexEnd,
                     Vertex vertexPrevious);

    /**
     * @param startVertex
     * @param endVertex
     * @return A list of vertexes for the shortest path starting with <code>startVertex</code> and ending with <code>endVertex</code>.
     */
    List<Vertex> getShortestPath(Vertex startVertex,
                                 Vertex endVertex);
}
