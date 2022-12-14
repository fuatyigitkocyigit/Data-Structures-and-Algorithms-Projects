//-----------------------------------------------------
// Title: Edge Class
// Author: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 2
// Assignment: 4
// Description: This class implements Edge to use in Edge Weighted Graph class.
//-----------------------------------------------------

public class Edge implements Comparable<Edge> { 

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
		//--------------------------------------------------------
		// Summary:Initializes an edge between vertices v and w of the given weight.
		//--------------------------------------------------------
    	
        if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
		//--------------------------------------------------------
		// Summary:Returns the weight of this edge.
		//--------------------------------------------------------
    	
        return weight;
    }

    public int either() {
		//--------------------------------------------------------
		// Summary:Returns either endpoint of this edge.
		//--------------------------------------------------------
    	
        return v;
    }

    public int other(int vertex) {
		//--------------------------------------------------------
		// Summary: Returns the endpoint of this edge that is different from the given vertex.
		//--------------------------------------------------------
    	
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    @Override
    public int compareTo(Edge that) {
		//--------------------------------------------------------
		// Summary: Compares two edges by weight.
		//--------------------------------------------------------
    	
        return Double.compare(this.weight, that.weight);
    }

    public String toString() {
		//--------------------------------------------------------
		// Summary: Returns a string representation of this edge.
		//--------------------------------------------------------
    	
        return String.format("%d-%d %.5f", v, w, weight);
    }
}