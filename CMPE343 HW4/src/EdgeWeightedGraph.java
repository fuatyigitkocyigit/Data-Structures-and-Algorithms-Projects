//-----------------------------------------------------
// Title: Edge Weighted Graph Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class implements the Edge Weighted Graph to use in PrimMST class.
//-----------------------------------------------------

import java.util.NoSuchElementException;

public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
		//--------------------------------------------------------
		// Summary: Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
		//--------------------------------------------------------
    	
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(int V, int E) {
		//--------------------------------------------------------
		// Summary: Initializes a random edge-weighted graph with {@code V} vertices and <em>E</em> edges.
		//--------------------------------------------------------
    	
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
        for (int i = 0; i < E; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public EdgeWeightedGraph(EdgeWeightedGraph G) {
		//--------------------------------------------------------
		// Summary: Initializes a new edge-weighted graph that is a deep copy of G.
		//--------------------------------------------------------
    	
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }

    public int V() {
		//--------------------------------------------------------
		// Summary: Returns the number of vertices in this edge-weighted graph.
		//--------------------------------------------------------
    	
        return V;
    }

    public int E() {
		//--------------------------------------------------------
		// Summary: Returns the number of edges in this edge-weighted graph.
		//--------------------------------------------------------
    	
        return E;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: throw an IllegalArgumentException unless 0 <= v < V.
		//--------------------------------------------------------
    	
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(Edge e) {
		//--------------------------------------------------------
		// Summary: Adds the undirected edge {@code e} to this edge-weighted graph.
		//--------------------------------------------------------
    	
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
		//--------------------------------------------------------
		// Summary: Returns the edges incident on vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
		//--------------------------------------------------------
		// Summary: Returns the degree of vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return adj[v].size();
    }

    public Iterable<Edge> edges() {
		//--------------------------------------------------------
		// Summary: Returns all edges in this edge-weighted graph.
		//--------------------------------------------------------
    	
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public String toString() {
		//--------------------------------------------------------
		// Summary: Returns a string representation of the edge-weighted graph.
		//--------------------------------------------------------
    	
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}