package graph;

import java.util.Set;

public interface Graph {

    Set<Vertex> getVertexes(); //avoir un sommet

    Vertex getVertex(String label);

    Set<Vertex> getSuccessors(Vertex vertex); //avoir les voisins des sommets
}
	