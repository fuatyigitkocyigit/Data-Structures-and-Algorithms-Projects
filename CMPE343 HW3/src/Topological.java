//-----------------------------------------------------
// Title: Topological Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements the topological sort algorithm to sort the tasks that 
//				is given in input
//-----------------------------------------------------

public class Topological {
    private Iterable<Integer> order;
    private int[] rank;

    public Topological(Digraph G) {
		//--------------------------------------------------------
		// Summary: Determines whether the digraph G has a topological order and finds the topological order.
		// Precondition: G is the digraph.
		//--------------------------------------------------------
    	
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }

    public Iterable<Integer> order() {
		//--------------------------------------------------------
		// Summary: Returns a topological order if the digraph has a topologial order. 
    	//			Returns null if otherwise.
		//--------------------------------------------------------
    	
        return order;
    }

    public boolean hasOrder() {
		//--------------------------------------------------------
		// Summary: Finds if the digraph has a topological order.
		// Postcondition: Returned true if it has a topological order, false if otherwise.
		//--------------------------------------------------------
    	
        return order != null;
    }

    @Deprecated
    public boolean isDAG() {
		//--------------------------------------------------------
		// Summary: Finds if the digraph have a topological order.
		// Postcondition: Returned true if the digraph has a topological order, false if otherwise.
		//--------------------------------------------------------
    	
        return hasOrder();
    }

    public int rank(int v) {
		//--------------------------------------------------------
		// Summary: Finds the rank of vertex v in the topological order. -1 if the digraph is not a DAG.
		// Precondition: v is the vertex.
		// Postcondition: Returned the position of vertex v in a topological order.
		//--------------------------------------------------------
    	
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else            return -1;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: throw an IllegalArgumentException unless 0 <= v < V.
		// Precondition: v is an integer.
		//--------------------------------------------------------
    	
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}