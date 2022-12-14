//-----------------------------------------------------
// Title: DirectedCycle Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements the directed cycle determining to use in topological sort.
//-----------------------------------------------------

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
		//--------------------------------------------------------
		// Summary: Determines whether the digraph G has a directed cycle and, if so, finds such a cycle.
		// Precondition: G is the digraph.
		//--------------------------------------------------------
    	
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) 
            	dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
		//--------------------------------------------------------
		// Summary: Runs DFS and find a directed cycle if one exists.
		// Precondition: G is the digraph, v is the integer.
		//--------------------------------------------------------
    	
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            if (cycle != null) return;

            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
		//--------------------------------------------------------
		// Summary: Finds if the digraph have a directed cycle.
		// Postcondition: return true if the digraph has a directed cycle, false if otherwise
		//--------------------------------------------------------
    	
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
		//--------------------------------------------------------
		// Summary: Returns a directed cycle if the digraph has a directed cycle, and null if otherwise.
		// Postcondition: return a directed cycle if the digraph has a directed cycle, and null if otherwise.
		//--------------------------------------------------------
    	
        return cycle;
    }

    private boolean check() {
		//--------------------------------------------------------
		// Summary: CertifÝES that digraph has a directed cycle if it reports one
		//--------------------------------------------------------
    	
        if (hasCycle()) {
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }

}