//-----------------------------------------------------
// Title: DirectedEdge Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 3
// Description: This class implements directed edges to use in directed graph.
//-----------------------------------------------------

public class DirectedEdge { 
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
		//--------------------------------------------------------
		// Summary: Initializes a directed edge from vertex v to vertex w with the given weight.
		// Precondition: v the tail vertex and w is the head vertex, weight is the weight of the directed edge.
		// Postcondition: Created the directed edge.
		//--------------------------------------------------------
    	
        if (v < 0) 
        	throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (w < 0) 
        	throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
		//--------------------------------------------------------
		// Summary: Returns the tail vertex of the directed edge.
		// Postcondition: Returned the tail vertex of the directed edge.
		//--------------------------------------------------------
    	
        return v;
    }

    public int to() {
		//--------------------------------------------------------
		// Summary: Returns the head vertex of the directed edge.
		// Postcondition: Returned the head vertex of the directed edge.
		//--------------------------------------------------------
    	
        return w;
    }

    public double weight() {
		//--------------------------------------------------------
		// Summary: Returns the weight of the directed edge.
		// Postcondition: Returned the weight of the directed edge.
		//--------------------------------------------------------
    	
        return weight;
    }

    public String toString() {
		//--------------------------------------------------------
		// Summary: Returns a string representation of the directed edge.
		// Postcondition: Returned a string representation of the directed edge.
		//--------------------------------------------------------
    	
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

}