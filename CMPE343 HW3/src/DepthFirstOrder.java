//-----------------------------------------------------
// Title: DepthFirstOrder Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements depth-first order to use in topological sort.
//-----------------------------------------------------

public class DepthFirstOrder {
    private boolean[] marked;
    private int[] pre;
    private int[] post;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
		//--------------------------------------------------------
		// Summary: Determines a depth-first order for the digraph G.
		// Precondition: G is the digraph.
		//--------------------------------------------------------
    	
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) 
            	dfs(G, v);

        assert check();
    }

    private void dfs(Digraph G, int v) {
		//--------------------------------------------------------
		// Summary: Runs DFS in digraph G from vertex v and compute preorder/postorder
		// Precondition: G is digraph and v is vertex.
		//--------------------------------------------------------
    	
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    public int pre(int v) {
		//--------------------------------------------------------
		// Summary: Returns the preorder number of vertex v.
		// Precondition: v is the vertex.
		// Postcondition: Returned the preorder number of vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return pre[v];
    }

    public int post(int v) {
		//--------------------------------------------------------
		// Summary: Returns the postorder number of vertex v.
		// Precondition: v is the vertex.
		// Postcondition: Returned the postorder number of vertex v.
		//--------------------------------------------------------
    	
        validateVertex(v);
        return post[v];
    }

    public Iterable<Integer> post() {
		//--------------------------------------------------------
		// Summary: Returns the vertices in postorder.
		// Postcondition: Returned the vertices in postorder.
		//--------------------------------------------------------
    	
        return postorder;
    }

    public Iterable<Integer> pre() {
		//--------------------------------------------------------
		// Summary: Returns the vertices in preorder.
		// Postcondition: Returned the vertices in preorder.
		//--------------------------------------------------------
    	
        return preorder;
    }

    public Iterable<Integer> reversePost() {
		//--------------------------------------------------------
		// Summary: Returns the vertices in reverse postorder.
		// Postcondition: Returned the vertices in reverse postorder.
		//--------------------------------------------------------
    	
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }

    private boolean check() {
		//--------------------------------------------------------
		// Summary: Checks that pre() and post() are consistent with pre(v) and post(v).
		//--------------------------------------------------------
    	
        int r = 0;
        for (int v : post()) {
            if (post(v) != r) {
            	System.out.println("post(v) and post() inconsistent");
                return false;
            }
            r++;
        }

        r = 0;
        for (int v : pre()) {
            if (pre(v) != r) {
                System.out.println("pre(v) and pre() inconsistent");
                return false;
            }
            r++;
        }
        return true;
    }

    private void validateVertex(int v) {
		//--------------------------------------------------------
		// Summary: Throws an IllegalArgumentException unless 0 <= v < V.
		// Precondition: v is integer.
		//--------------------------------------------------------
    	
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}
