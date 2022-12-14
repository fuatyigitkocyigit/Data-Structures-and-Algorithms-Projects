//-----------------------------------------------------
// Title: Digraph Class
// Author: Fuat Yiğit Koçyiğit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements the directed graph for using in topological sort.
//-----------------------------------------------------

import java.util.NoSuchElementException;
import java.io.*;
import java.util.*;

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private int[] indegree;
    
    public Digraph(int V) {
		//--------------------------------------------------------
		// Summary: Initializes an empty digraph with V vertices.
		// Precondition: V is the number of vertices.
		// Postcondition: Digraph has been created with V vertices.
		//--------------------------------------------------------
    	
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    
    public Digraph(Scanner in) {
		//--------------------------------------------------------
		// Summary: Initializes a digraph from the specified input stream.
		// Precondition: in is the input stream.
		// Postcondition: Digraph has been created from the input stream.
		//--------------------------------------------------------
    	
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.nextInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
            indegree = new int[V];
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.nextInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }

    public Digraph(Digraph G) {
		//--------------------------------------------------------
		// Summary: Initializes a new digraph that is a deep copy of the specified digraph.
		// Precondition: G is the digraph to copy.
		// Postcondition: The digraph has been copied and created.
		//--------------------------------------------------------
    	
        if (G == null) 
        	throw new IllegalArgumentException("argument is null");

        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");

        indegree = new int[V];
        for (int v = 0; v < V; v++)
            this.indegree[v] = G.indegree(v);

        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
        
    public int V() {
		//--------------------------------------------------------
		// Summary: Returns the number of vertices in this digraph.
		//--------------------------------------------------------
    	
        return V;
    }

    public int E() {
		//--------------------------------------------------------
		// Summary: Returns the number of edges in this digraph.
		//--------------------------------------------------------
    	
        return E;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: Throws an IllegalArgumentException unless 0 <= v < V
		// Precondition: v is an integer value.
		//--------------------------------------------------------
    	
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
		//--------------------------------------------------------
		// Summary: Adds the directed edge v→w to this digraph.
		// Precondition: v is the tail and w is the head vertex.
		// Postcondition: Added the edge.
		//--------------------------------------------------------
    	
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public Iterable<Integer> adj(int v) {
		//--------------------------------------------------------
		// Summary: Returns the vertices adjacent from vertex v in this digraph.
		// Precondition: v is the vertex.
		// Postcondition: Returned the vertices adjacent from vertex v in this digraph, as an iterable.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
		//--------------------------------------------------------
		// Summary: Returns the number of directed edges incident from vertex v.
		// Precondition: v is the vertex.
		// Postcondition: Returned the outdegree of vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
		//--------------------------------------------------------
		// Summary: Returns the number of directed edges incident to vertex v.
		// Precondition: v is the vertex.
		// Postcondition: Returned the indegree of vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return indegree[v];
    }

    public Digraph reverse() {
		//--------------------------------------------------------
		// Summary: Returns the reverse of the digraph.
		// Postcondition: Returned the reverse of the digraph.
		//--------------------------------------------------------
    	
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    public String toString() {
		//--------------------------------------------------------
		// Summary: Returns a string representation of the graph.
		//--------------------------------------------------------
    	
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}