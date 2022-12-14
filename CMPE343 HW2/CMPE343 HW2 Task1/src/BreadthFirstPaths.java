//-----------------------------------------------------
// Title: Depth First Search Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the Breadth First Search algorithm.
//-----------------------------------------------------


public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstPaths(Graph G, int s) {
		//--------------------------------------------------------
		// Summary: Computes the shortest path between the source vertex and every other vertex in the graph.
		// Precondition: Method takes a Graph and an integer as input.
		// Postcondition: The BreadthFirstPaths has been created.
		//--------------------------------------------------------
    	
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        validateVertex(s);
        bfs(G, s);

        assert check(G, s);
    }

    public BreadthFirstPaths(Graph G, Iterable<Integer> sources) {
		//--------------------------------------------------------
		// Summary: Computes the shortest path between any one of the source vertices and every other vertex in graph.
		// Precondition: Method takes a Graph and an Iterable<Integer> as input.
		// Postcondition: The BreadthFirstPaths has been created.
		//--------------------------------------------------------
    	
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        validateVertices(sources);
        bfs(G, sources);
    }

    private void bfs(Graph G, int s) {
		//--------------------------------------------------------
		// Summary: Makes breadth-first search from a single source.
		// Precondition: Method takes a Graph and an integer as input.
		// Postcondition: Breadth-first search is done.
		//--------------------------------------------------------
    	
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    private void bfs(Graph G, Iterable<Integer> sources) {
		//--------------------------------------------------------
		// Summary: Makes breadth-first search from multiple sources.
		// Precondition: Method takes a Graph and an Iterable<Integer> as input.
		// Postcondition: Breadth-first search is done.
		//--------------------------------------------------------
    	
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
		//--------------------------------------------------------
		// Summary: Checks if there is a path between the source vertex and given vertex.
		// Precondition: Method takes an integer as input.
		// Postcondition: Returned true if there is a path, false if otherwise.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v) {
		//--------------------------------------------------------
		// Summary: Returns the number of edges in a shortest path between the source vertex and given vertex.
		// Precondition: Method takes an integer as input.
		// Postcondition: Returned the number of edges in the shortest path.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
		//--------------------------------------------------------
		// Summary: Returns a shortest path between the source vertex and given vertex.
		// Precondition: Method takes an integer as input.
		// Postcondition: Returned the sequence of vertices on a shortest path, as an Iterable.
		//--------------------------------------------------------
    	
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    private boolean check(Graph G, int s) {
		//--------------------------------------------------------
		// Summary: Checking if the conditions are okay for a healthy algorithm.
		//--------------------------------------------------------

        if (distTo[s] != 0) {
        	System.out.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                	System.out.println("edge " + v + "-" + w);
                	System.out.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                	System.out.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                	System.out.println("edge " + v + "-" + w);
                	System.out.println("distTo[" + v + "] = " + distTo[v]);
                	System.out.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        for (int w = 0; w < G.V(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
            	System.out.println("shortest path edge " + v + "-" + w);
            	System.out.println("distTo[" + v + "] = " + distTo[v]);
            	System.out.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: Checks the given integer and throws an IllegalArgumentException unless {0 <= v < V}
		// Precondition: An integer has been taken as input.
		//--------------------------------------------------------
    	
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    private void validateVertices(Iterable<Integer> vertices) {
		//--------------------------------------------------------
		// Summary: Checks the given Iterable<Integer> and throws an IllegalArgumentException if vertices is null,
        // has zero vertices, or has a vertex that is not between 0 and V-1
		// Precondition: An Iterable<Integer> has been taken as input.
		//--------------------------------------------------------
    	
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int V = marked.length;
        int count = 0;
        for (Integer v : vertices) {
            count++;
            if (v == null) {
                throw new IllegalArgumentException("vertex is null");
            }
            validateVertex(v);
        }
        if (count == 0) {
            throw new IllegalArgumentException("zero vertices");
        }
    }
}