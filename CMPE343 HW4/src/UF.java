//-----------------------------------------------------
// Title: UF Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class implements the UF to use in PrimMST class.
//-----------------------------------------------------

public class UF {

    private int[] parent;
    private byte[] rank;
    private int count;

    public UF(int n) {
		//--------------------------------------------------------
		// Summary: Initializes an empty union-find data structure with n elements 0 through n-1.
		//--------------------------------------------------------
    	
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
		//--------------------------------------------------------
		// Summary: Returns the canonical element of the set containing element p.
		//--------------------------------------------------------
    	
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public int count() {
		//--------------------------------------------------------
		// Summary: Returns the number of sets.
		//--------------------------------------------------------
    	
        return count;
    }
 
    @Deprecated
    public boolean connected(int p, int q) {
		//--------------------------------------------------------
		// Summary: Returns true if the two elements are in the same set.
		//--------------------------------------------------------
    	
        return find(p) == find(q);
    }
    
    public void union(int p, int q) {
		//--------------------------------------------------------
		// Summary: Merges the set containing element p with the the set containing element q.
		//--------------------------------------------------------
    	
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    private void validate(int p) {
		//--------------------------------------------------------
		// Summary: Validate that p is a valid index
		//--------------------------------------------------------
    	
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    }
}