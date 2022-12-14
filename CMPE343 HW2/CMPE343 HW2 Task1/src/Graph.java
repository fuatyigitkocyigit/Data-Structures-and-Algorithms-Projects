//-----------------------------------------------------
// Title: Graph Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the Graph to use in main class.
//-----------------------------------------------------

import java.util.NoSuchElementException;
import java.io.*;
import java.util.*;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    public Graph(int V) {
		//--------------------------------------------------------
		// Summary: Initializes an empty graph with V vertices and 0 edges.
		// Precondition: Method takes an integer for number of vertices.
		// Postcondition: The graph has been created with given input.
		//--------------------------------------------------------
    	
        if (V < 0) 
        	throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(Scanner scanner) {
		//--------------------------------------------------------
		// Summary: Initializes a graph from the specified scanner.
		// Precondition: Method takes scanner as input.
		// Postcondition: The scanner has been selected and the graph has been created.
		//--------------------------------------------------------
    	
        if (scanner.next() == null) 
        	throw new IllegalArgumentException("argument is null");
        try {
            this.V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
            
            int genislik = scanner.nextInt();
            int uzunluk = scanner.nextInt();
            int temp=0;
            
    		for(int i=0; i<uzunluk; i++) {
    			String before=scanner.next();
    			char[] chars = before.toCharArray();
    			for(int ii=0; ii<genislik; ii++) {
    				String now=scanner.next();
    				char[] chars2 = now.toCharArray();
    				if(!(chars[ii]==chars2[ii])) {
    	                int v = temp;
    	                int w = temp+1;
    	                validateVertex(v);
    	                validateVertex(w);
    					addEdge(temp, temp+1);
    				}
    				before=now;
    				temp++;
    			}
    			
    		}
            
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public Graph(Graph G) {
		//--------------------------------------------------------
		// Summary: Initializes a new graph with copying the given Graph G.
		// Precondition: Method takes a Graph to copy.
		// Postcondition: The graph is taken and the new graph is created.
		//--------------------------------------------------------
    	
        this.V = G.V();
        this.E = G.E();
        if (V < 0) 
        	throw new IllegalArgumentException("Number of vertices must be non-negative");

        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
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
		// Summary: Returns the number of vertices in the graph.
		//--------------------------------------------------------
    	
        return V;
    }

    public int E() {
		//--------------------------------------------------------
		// Summary: Returns the number of edges in the graph.
		//--------------------------------------------------------
    	
        return E;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: Checks the given integer and throws an IllegalArgumentException unless {0 <= v < V}
		// Precondition: An integer has been taken
		//--------------------------------------------------------
    	
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
		//--------------------------------------------------------
		// Summary: Adds the undirected edge v-w to this graph.
		// Precondition: Takes two integers from the user.
		// Postcondition: The input has been taken and edges has been added.
		//--------------------------------------------------------
    	
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
		//--------------------------------------------------------
		// Summary: Returns the vertices adjacent to vertex v.
		// Precondition: Method takes an integer value as input.
		// Postcondition: Returned the adjacent of the integer v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v];
    }
    
    public int degree(int v) {
		//--------------------------------------------------------
		// Summary: Returns the degree of vertex.
		// Precondition: Method takes an integer.
		// Postcondition: The degree of the given vertex is returned.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v].size();
    }

    public String toString() {
		//--------------------------------------------------------
		// Summary: Returns a string representation of this graph.
		//--------------------------------------------------------
    	
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}