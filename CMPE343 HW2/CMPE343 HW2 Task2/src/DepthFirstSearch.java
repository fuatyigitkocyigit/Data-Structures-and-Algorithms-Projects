//-----------------------------------------------------
// Title: Depth First Search Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the Depth First Search algorithm.
//-----------------------------------------------------

import java.io.*;
import java.util.*;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
		//--------------------------------------------------------
		// Summary: Computes the vertices in graph that are connected to the source.
		// Precondition: Method takes a Graph and an integer as input.
		// Postcondition: The DepthFirstSearch has been created.
		//--------------------------------------------------------
    	
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
		//--------------------------------------------------------
		// Summary: Depth-first searches from a vertex
		// Precondition: Method takes a Graph and an integer as input.
		// Postcondition: Depth-first search is done.
		//--------------------------------------------------------
    	
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
		//--------------------------------------------------------
		// Summary: Checks if there is a path between the source vertex and given vertex.
		// Precondition: Method takes an integer as input.
		// Postcondition: Returned the boolean value.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return marked[v];
    }

    public int count() {
		//--------------------------------------------------------
		// Summary: Returns the number of vertices connected to the source vertex.
		// Postcondition: Returned the count value.
		//--------------------------------------------------------
    	
        return count;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: Checks the given integer and throws an IllegalArgumentException unless {0 <= v < V}
		// Precondition: An integer has been taken
		//--------------------------------------------------------
    	
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
