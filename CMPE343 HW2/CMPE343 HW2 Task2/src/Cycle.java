//-----------------------------------------------------
// Title: Depth First Search Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 2
// Description: This class implements the Cycle detection algorithm.
//-----------------------------------------------------

public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G) {
		//--------------------------------------------------------
		// Summary: The constructor of the Cycle Class.
		//--------------------------------------------------------
		
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++)
			if (!marked[s])
				dfs(G, s, s);
	}
	
	public void dfs(Graph G, int v, int u) {
		//--------------------------------------------------------
		// Summary: Uses the Depth First Search to find the cycles.
		//--------------------------------------------------------
		
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w, v);
			else if (w != u) hasCycle = true;
	}

	public boolean hasCycle() { 
		//--------------------------------------------------------
		// Summary: Returns if the graph has a cycle.
		//--------------------------------------------------------
		
		return hasCycle; 
	}
}